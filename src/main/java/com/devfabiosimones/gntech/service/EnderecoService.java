package com.devfabiosimones.gntech.service;

import com.devfabiosimones.gntech.config.ViaCepConfig;
import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.projections.EnderecoDetailsProjection;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import com.devfabiosimones.gntech.service.exceptions.ResourceAlreadyExistsException;
import com.devfabiosimones.gntech.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final ViaCepConfig viaCepConfig;
    private final EnderecoReposity enderecoReposity;

    public EnderecoService(ViaCepConfig viaCepConfig, EnderecoReposity enderecoReposity) {
        this.viaCepConfig = viaCepConfig;
        this.enderecoReposity = enderecoReposity;
    }

    public Endereco buscarESalvarEndereco(String cep) {
        buscaCepBanco(cep);
        EnderecoDTO dto = consultaCepExterno(cep);
        Endereco endereco = salvaBanco(dto);

        return enderecoReposity.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoReposity.findAll();
    }

    private static Endereco salvaBanco(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setCep(dto.getCep().replaceAll("\\D", ""));
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setBairro(dto.getBairro());
        endereco.setLocalidade(dto.getLocalidade());
        endereco.setUf(dto.getUf());
        endereco.setDdd(dto.getDdd());
        return endereco;
    }

    private EnderecoDTO consultaCepExterno(String cep) {
        EnderecoDTO dto = viaCepConfig.consultarCep(cep);
        if (dto == null || dto.getCep() == null) {
            throw new ResourceNotFoundException("CEP inválido ou não encontrado: " + cep);
        }
        return dto;
    }

    private void buscaCepBanco(String cep) {
        List<EnderecoDetailsProjection> existeBanco = enderecoReposity.buscaCepNoBanco(cep);
        if (!existeBanco.isEmpty()) {
            throw new ResourceAlreadyExistsException("CEP já existe no banco de dados: " + cep);
        }
    }

}

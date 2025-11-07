package com.devfabiosimones.gntech.service;

import com.devfabiosimones.gntech.config.ViaCepConfig;
import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final ViaCepConfig viaCepConfig;
    private final EnderecoReposity enderecoReposity;

    public EnderecoService(ViaCepConfig viaCepConfig, EnderecoReposity enderecoReposity) {
        this.viaCepConfig = viaCepConfig;
        this.enderecoReposity = enderecoReposity;
    }

    public Endereco buscarOuSalvarEndereco(String cep) {
        return enderecoReposity.findByCep(cep)
                .orElseGet(() -> {
                    EnderecoDTO dto = viaCepConfig.consultarCep(cep);
                    Endereco endereco = new Endereco();
                    BeanUtils.copyProperties(dto, endereco);
                    return enderecoReposity.save(endereco);
                });
    }
}

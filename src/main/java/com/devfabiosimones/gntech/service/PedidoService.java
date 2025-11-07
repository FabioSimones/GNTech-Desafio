package com.devfabiosimones.gntech.service;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.Pedido;
import com.devfabiosimones.gntech.entity.dto.EnderecoDTO;
import com.devfabiosimones.gntech.entity.dto.PedidoDTO;
import com.devfabiosimones.gntech.repository.EnderecoReposity;
import com.devfabiosimones.gntech.repository.ItemRepository;
import com.devfabiosimones.gntech.repository.PedidoRepository;
import com.devfabiosimones.gntech.service.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;
    private final EnderecoService enderecoService;
    private final EnderecoReposity enderecoReposity;

    public PedidoService(PedidoRepository pedidoRepository, ItemRepository itemRepository,
                         EnderecoService enderecoService, EnderecoReposity enderecoReposity) {
        this.pedidoRepository = pedidoRepository;
        this.itemRepository = itemRepository;
        this.enderecoService = enderecoService;
        this.enderecoReposity = enderecoReposity;
    }

    public Pedido criarPedido(String nomeCliente, String cep, List<Long> itemIds) {
        Endereco endereco = verificaCepCadastrado(cep);

        List<Item> itens = itemRepository.findAllById(itemIds);

        if (itens.size() != itemIds.size()) {
            throw new BadRequestException("Um ou mais itens informados não foram encontrados.");
        }

        Pedido pedido = new Pedido();
        pedido.setNomeCliente(nomeCliente);
        pedido.setDtCriacao(Instant.now());
        pedido.setEndereco(endereco);
        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }
    private Endereco verificaCepCadastrado(String cep) {
        String cepNormalizado = cep.replaceAll("[^\\d]", "");
        return enderecoReposity.findByCep(cepNormalizado)
                .orElseThrow(() -> new BadRequestException("CEP não cadastrado: " + cepNormalizado));
    }

    public List<Pedido> buscarPorCep(String cep) {
        String cepNormalizado = cep.replaceAll("[^\\d]", "");
        return pedidoRepository.findByEnderecoCep(cepNormalizado);
    }

}

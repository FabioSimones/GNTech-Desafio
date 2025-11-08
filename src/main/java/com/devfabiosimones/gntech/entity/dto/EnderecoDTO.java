package com.devfabiosimones.gntech.entity.dto;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.Pedido;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer ddd;
    private List<PedidoDTOResumido> pedidos = new ArrayList<>();

    public EnderecoDTO() {
    }

    public EnderecoDTO(String cep, String logradouro, String bairro, String localidade, String uf, Integer ddd, List<Pedido> pedidos) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ddd = ddd;
    }

    public EnderecoDTO(Endereco entity) {
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
        ddd = entity.getDdd();
        if (entity.getPedidos() != null) {
            for (Pedido pedido : entity.getPedidos()) {
                List<Long> itemIds = pedido.getItens().stream()
                        .map(Item::getId)
                        .collect(Collectors.toList());

                this.pedidos.add(new PedidoDTOResumido(
                        pedido.getNomeCliente(),
                        pedido.getEndereco().getCep(),
                        itemIds
                ));
            }
        }

    }
    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Integer getDdd() {
        return ddd;
    }

    public List<PedidoDTOResumido> getPedidos() {
        return pedidos;
    }
}



package com.devfabiosimones.gntech.entity.dto;

import java.util.List;

public class PedidoDTOResumido {

    private String nomeCliente;
    private String cep;
    private List<Long> itemIds;

    public PedidoDTOResumido() {
    }

    public PedidoDTOResumido(String nomeCliente, String cep, List<Long> itemIds) {
        this.nomeCliente = nomeCliente;
        this.cep = cep;
        this.itemIds = itemIds;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCep() {
        return cep;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }
}

package com.devfabiosimones.gntech.entity.dto;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.Pedido;

import java.time.Instant;

public class PedidoDTO {

    private Instant dtCriacao;
    private String nomeCliente;
    private Endereco endereco;
    private Item item;

    public PedidoDTO() {
    }

    public PedidoDTO(Instant dtCriacao, String nomeCliente, Endereco endereco, Item item) {
        this.dtCriacao = dtCriacao;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.item = item;
    }

    public PedidoDTO(Pedido entity) {
        dtCriacao = dtCriacao;
        nomeCliente = nomeCliente;
        endereco = endereco;
        item = item;
    }

    public Instant getDtCriacao() {
        return dtCriacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Item getItem() {
        return item;
    }
}

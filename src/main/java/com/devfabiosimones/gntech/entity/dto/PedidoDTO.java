package com.devfabiosimones.gntech.entity.dto;

import com.devfabiosimones.gntech.entity.Endereco;
import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.Pedido;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private Instant dtCriacao;
    private String nomeCliente;
    private String cep;
    private List<ItemDTOResumido> itens = new ArrayList<>();

    public PedidoDTO() {
    }

    public PedidoDTO(Instant dtCriacao, String nomeCliente, String cep, List<ItemDTOResumido> itens) {
        this.dtCriacao = dtCriacao;
        this.nomeCliente = nomeCliente;
        this.cep = cep;
        this.itens = itens;
    }

    public PedidoDTO(Pedido entity) {
        this.nomeCliente = entity.getNomeCliente();
        this.dtCriacao = entity.getDtCriacao();
        if (entity.getEndereco() != null) {
            this.cep = entity.getEndereco().getCep();
        }

        if (entity.getItens() != null) {
            for (Item item : entity.getItens()) {
                this.itens.add(new ItemDTOResumido(item.getId(), item.getNomeProduto()));
            }
        }
    }

    public Instant getDtCriacao() {
        return dtCriacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCep() {
        return cep;
    }

    public List<ItemDTOResumido> getItens() {
        return itens;
    }
}



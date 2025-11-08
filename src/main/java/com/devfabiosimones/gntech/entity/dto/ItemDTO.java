package com.devfabiosimones.gntech.entity.dto;

import com.devfabiosimones.gntech.entity.Item;

import java.math.BigDecimal;

public class ItemDTO {

    private Long id;
    private String nomeProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String nomeProduto, BigDecimal precoUnitario, Integer quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public ItemDTO(Item entity) {
        this.id = entity.getId();
        this.nomeProduto = entity.getNomeProduto();
        this.precoUnitario = entity.getPrecoUnitario();
        this.quantidade = entity.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}

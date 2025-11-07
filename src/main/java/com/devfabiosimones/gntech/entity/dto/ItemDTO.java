package com.devfabiosimones.gntech.entity.dto;

import com.devfabiosimones.gntech.entity.Item;
import com.devfabiosimones.gntech.entity.Pedido;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

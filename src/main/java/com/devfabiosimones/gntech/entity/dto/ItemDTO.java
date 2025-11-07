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

    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private List<Pedido> pedidos = new ArrayList<>();

    public ItemDTO() {
    }

    public ItemDTO(String nomeProduto, Integer quantidade, BigDecimal precoUnitario, List<Pedido> pedidos) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.pedidos = pedidos;
    }

    public ItemDTO(Item entity) {
        nomeProduto = entity.getNomeProduto();
        quantidade = entity.getQuantidade();
        precoUnitario = entity.getPrecoUnitario();
        pedidos = new ArrayList<>(entity.getPedidos());
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

package com.devfabiosimones.gntech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dtCriacao;

    @Column(length = 50)
    private String nomeCliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "pedido_item",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens;

    public Pedido() {
    }

    public Pedido(Long id, Instant dtCriacao, String nomeCliente, Endereco endereco, List<Item> itens) {
        this.id = id;
        this.dtCriacao = dtCriacao;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Instant dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

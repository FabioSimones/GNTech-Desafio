package com.devfabiosimones.gntech.entity.dto;

public class ItemDTOResumido {
    private Long id;
    private String nome;

    public ItemDTOResumido(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

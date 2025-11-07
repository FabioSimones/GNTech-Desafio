package com.devfabiosimones.gntech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 9, nullable = false)
    private String cep;

    @Column(length = 80)
    private String logradouro;

    @Column(length = 20)
    private String bairro;

    @Column(length = 20)
    private String localidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 3)
    private Integer ddd;

    @OneToMany(mappedBy = "endereco")
    private List<Pedido> pedidos = new ArrayList<>();
}

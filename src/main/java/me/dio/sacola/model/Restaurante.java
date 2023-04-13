package me.dio.sacola.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

import java.util.List;

public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> cardapio;

    @Embedded
    private Endereco endereco;

}

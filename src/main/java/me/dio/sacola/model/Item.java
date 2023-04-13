package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Produto produto;

    private int quantidade;

    @ManyToOne
    @JsonIgnore
    private Sacola sacola;



}

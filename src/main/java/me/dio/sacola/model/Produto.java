package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double valorUnitario;

    @Builder.Default
    private Boolean disponivel = true;

    @ManyToOne
    @JsonIgnore
    private Restaurante restaurante;

}

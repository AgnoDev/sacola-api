package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // cria construtor com todos os atributos
@NoArgsConstructor // cria construtor vazio exigido pelo Hibernate
@Data // cria getters, setters, equals e hashcode (talvez alguns que nem sejam utilizados)
@Entity // converte a classe em tabela no banco de dados
@Builder // simplifica criação objetos e auxilia na utilização da classe na camada Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ignora erros JSon para atributos Lazy

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne // um item para um produto (classe To atributo)
    private Produto produto;

    private int quantidade;

    @ManyToOne // muitos itens para uma sacola (classe To atributo)
    @JsonIgnore
    private Sacola sacola;



}

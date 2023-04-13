package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagto;

import java.util.List;

@AllArgsConstructor // cria construtor com todos os atributos
@NoArgsConstructor // cria construtor vazio exigido pelo Hibernate
@Data // cria getters, setters, equals e hashcode (talvez alguns que nem sejam utilizados)
@Entity // converte a classe em tabela no banco de dados
@Builder // simplifica criação objetos e auxilia na utilização da classe na camada Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ignora erros JSon para atributos Lazy
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // muitas sacolas para um cliente (classe To atributo)
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL) // uma sacola para muitos itens (casse To atributo)
    private List<Item> itens;

    private Double valorTotal;
    @Enumerated
    private FormaPagto FormaPagto;

    private Boolean fechada;

}

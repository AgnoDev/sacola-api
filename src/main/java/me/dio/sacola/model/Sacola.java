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
@Data // cria todos os getters e setters, talvez alguns que nem sejam utilizados
@Entity // cria tabela no banco de dados
@Builder // auxilia na utilização da classe na camada Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ignora erros JSon para atributos Lazy
public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;

    private Double valorTotal;
    @Enumerated
    private FormaPagto FormaPagto;

    private Boolean fechada;

}

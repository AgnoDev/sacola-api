package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // cria construtor com todos os atributos
@NoArgsConstructor // cria construtor vazio exigido pelo Hibernate
@Data // cria getters, setters, equals e hashcode (talvez alguns que nem sejam utilizados)
@Builder // simplifica criação objetos e auxilia na utilização da classe na camada Service
@Embeddable // cria os atributos dessa classe dentro de outra tabela e não precisa criar uma tabela específica
public class Endereco {

    private String cep;
    private String complemento;
}

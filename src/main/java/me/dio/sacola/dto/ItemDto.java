package me.dio.sacola.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // cria construtor com todos os atributos
@NoArgsConstructor // cria construtor vazio exigido pelo Hibernate
@Data // cria getters, setters, equals e hashcode (talvez alguns que nem sejam utilizados)
@Builder // simplifica criação objetos e auxilia na utilização da classe na camada Service
@Embeddable // anotação de classe: cria os atributos dessa classe dentro da tabela @Embedded e não precisa criar uma tabela específica

public class ItemDto {

    private Long idProduto;
    private Long idSacola;
    private int quantidade;
}



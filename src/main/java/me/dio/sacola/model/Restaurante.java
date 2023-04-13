package me.dio.sacola.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;import org.hibernate.annotations.OnDelete;
import java.util.List;

@AllArgsConstructor // cria construtor com todos os atributos
@NoArgsConstructor // cria construtor vazio exigido pelo Hibernate
@Data // cria getters, setters, equals e hashcode (talvez alguns que nem sejam utilizados)
@Entity // converte a classe em tabela no banco de dados
@Builder // simplifica criação objetos e auxilia na utilização da classe na camada Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ignora erros JSon para atributos Lazy

public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL) // um restaurante para varios produtos (classe To produto)
    private List<Produto> cardapio;      // cascade.all > alterações em restaurante, afeta todos os produtos desse restaurante


    @Embedded // anotação de atributo: recebe os atributos de outra classe em sua tabela
    private Endereco endereco;

}

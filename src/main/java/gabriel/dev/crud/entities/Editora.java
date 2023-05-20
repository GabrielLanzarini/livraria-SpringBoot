package gabriel.dev.crud.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "editoras")
@Entity
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String localizacao;
}

package gabriel.dev.crud.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "autores")
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String nacionalidade;
}

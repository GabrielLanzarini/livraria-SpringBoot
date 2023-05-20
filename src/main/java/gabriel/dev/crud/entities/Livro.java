package gabriel.dev.crud.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "livros")
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Boolean emprestado;

    @OneToOne
    @JoinColumn(name = "autor_id",  referencedColumnName = "id")
    private Autor autor;

    @Temporal(TemporalType.DATE)
    private Date ano;

    @OneToOne
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    private Editora editora;

    private String genero;
}

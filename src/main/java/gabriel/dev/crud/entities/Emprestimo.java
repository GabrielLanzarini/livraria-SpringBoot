package gabriel.dev.crud.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "emprestimos")
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;

    @Temporal(TemporalType.DATE)
    private Date data_emp;

    @Temporal(TemporalType.DATE)
    private Date data_dev;
}

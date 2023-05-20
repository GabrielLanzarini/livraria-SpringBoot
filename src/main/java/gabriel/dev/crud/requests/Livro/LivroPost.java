package gabriel.dev.crud.requests.Livro;

import lombok.Data;

@Data
public class LivroPost {
    private String titulo;
    private long autor_id;
    private long editora_id;
    private String genero;
}

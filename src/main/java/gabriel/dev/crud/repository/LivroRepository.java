package gabriel.dev.crud.repository;

import gabriel.dev.crud.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {}

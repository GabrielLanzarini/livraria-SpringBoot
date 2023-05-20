package gabriel.dev.crud.repository;

import gabriel.dev.crud.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}

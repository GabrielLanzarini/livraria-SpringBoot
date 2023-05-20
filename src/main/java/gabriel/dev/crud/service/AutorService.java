package gabriel.dev.crud.service;


import gabriel.dev.crud.entities.Autor;
import gabriel.dev.crud.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public List<Autor> listAll(){
        return autorRepository.findAll();
    }

    public Autor listOne(long id){
        return autorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Autor" +
                " não encontrado!"));
    }

    public Autor create(Autor autor){
        for (Autor aut: listAll()){
            if(aut.getNome().equals(autor.getNome())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Autor já cadastrado!");
            }
        }
        return autorRepository.save(autor);
    }

    public void delete(long id){
        autorRepository.delete(listOne(id));
    }

    public void replace(Autor autor, long id){
        autor.setId(id);
        autorRepository.save(autor);
    }
}

package gabriel.dev.crud.service;


import gabriel.dev.crud.entities.Editora;
import gabriel.dev.crud.repository.EditoraRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class EditoraService {
    final private EditoraRepository editoraRepository;

    public Editora listOne(long id){
        return editoraRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    public List<Editora> listAll(){
        return editoraRepository.findAll();
    }

    public Editora create(Editora editora){
        for(Editora edt: listAll()){
            if(edt.getNome().equals(editora.getNome())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Editora já cadastrada!");
            }
        }
        return editoraRepository.save(editora);
    }

    public void delete(long id){
        editoraRepository.delete(listOne(id));
    }

    public void replace(Editora editora, long id){
        editora.setId(id);
        editoraRepository.save(editora);
    }
}

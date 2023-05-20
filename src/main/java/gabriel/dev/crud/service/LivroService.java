package gabriel.dev.crud.service;

import gabriel.dev.crud.entities.Livro;
import gabriel.dev.crud.mapper.LivroMapper;
import gabriel.dev.crud.repository.EditoraRepository;
import gabriel.dev.crud.repository.LivroRepository;
import gabriel.dev.crud.requests.Livro.LivroPost;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
    private final AutorService autorService;
    private final EditoraService editoraService;

    public List<Livro> listAll(){
        return livroRepository.findAll();
    }

    public Livro listOne(long id){
        return livroRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não " +
                "encontrado"));
    }

    public Livro create(LivroPost livro){
        Livro saveLivro = LivroMapper.INSTANCE.toLivro(livro);
        saveLivro.setAutor(autorService.listOne(livro.getAutor_id()));
        saveLivro.setEditora(editoraService.listOne(livro.getEditora_id()));
        saveLivro.setAno(new Date());
        return livroRepository.save(saveLivro);
    }

    public void replaceEditora(long id, long editoraId){
        Livro livro = listOne(id);
        livro.setEditora(editoraService.listOne(editoraId));
        livroRepository.save(livro);
    }

    public void replaceAutor(long id, long autorId){
        Livro livro = listOne(id);
        livro.setAutor(autorService.listOne(autorId));
        livroRepository.save(livro);
    }

    public void delete(long id){
        livroRepository.delete(listOne(id));
    }

}

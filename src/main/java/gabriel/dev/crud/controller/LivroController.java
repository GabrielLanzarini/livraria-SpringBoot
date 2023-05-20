package gabriel.dev.crud.controller;


import gabriel.dev.crud.entities.Livro;
import gabriel.dev.crud.requests.Livro.LivroPost;
import gabriel.dev.crud.service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("livro")
@AllArgsConstructor
public class LivroController {
    final private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listLivros(){
        return new ResponseEntity<>(livroService.listAll() ,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Livro> listOneLivro(@PathVariable long id){
        return new ResponseEntity<>(livroService.listOne(id) ,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody LivroPost livro){
        return new ResponseEntity<>(livroService.create(livro), HttpStatus.CREATED);
    }

    @PutMapping(path = "/replace/editora/{id}/{editora}")
    public ResponseEntity<Void> replaceLivroEditora(@PathVariable long id,@PathVariable long editora){
        livroService.replaceEditora(id, editora);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/replace/autor/{id}/{autorId}")
    public ResponseEntity<Void> replaceLivroAutor(@PathVariable long id,@PathVariable long autorId){
        livroService.replaceAutor(id, autorId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable long id){
        livroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

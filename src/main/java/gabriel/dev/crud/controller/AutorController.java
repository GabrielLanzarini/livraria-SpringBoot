package gabriel.dev.crud.controller;


import gabriel.dev.crud.entities.Autor;
import gabriel.dev.crud.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("autor")
@AllArgsConstructor
public class AutorController {
    final private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listAutor(){
        return new ResponseEntity<>(autorService.listAll() ,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Autor> listOneAutor(@PathVariable long id){
        return new ResponseEntity<>(autorService.listOne(id) ,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.create(autor), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replaceAutor(@PathVariable long id, @RequestBody Autor autor){
        autorService.replace(autor, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable long id){
        autorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

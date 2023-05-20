package gabriel.dev.crud.controller;


import gabriel.dev.crud.entities.Editora;
import gabriel.dev.crud.repository.EditoraRepository;
import gabriel.dev.crud.service.EditoraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("editora")
@AllArgsConstructor
public class EditoraController {
    final private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> listEditora(){
        return ResponseEntity.ok(editoraService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Editora> listOneEditora(@PathVariable long id){
        return ResponseEntity.ok(editoraService.listOne(id));
    }

    @PostMapping
    public ResponseEntity<Editora> createEditora(@RequestBody Editora editora){
        return new ResponseEntity<>(editoraService.create(editora), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replaceEditora(@RequestBody Editora editora, @RequestParam long id){
        editoraService.replace(editora, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEditora(@PathVariable long id){
        editoraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

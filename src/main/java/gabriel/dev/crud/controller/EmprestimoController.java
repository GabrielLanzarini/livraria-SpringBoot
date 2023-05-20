package gabriel.dev.crud.controller;


import gabriel.dev.crud.entities.Emprestimo;
import gabriel.dev.crud.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("emprestimo")
@AllArgsConstructor
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listEmprestimo(){
        return new ResponseEntity<>(emprestimoService.listAll() ,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Emprestimo> listOneEmprestimo(@PathVariable long id){
        return new ResponseEntity<>(emprestimoService.listOne(id) ,HttpStatus.OK);
    }

    @PostMapping(path = "{id}")
    public ResponseEntity<Emprestimo> createEmprestimo(@PathVariable long id){
        return new ResponseEntity<>(emprestimoService.create(id), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Emprestimo> devolucaoEmprestimo(@PathVariable long id){
        return new ResponseEntity<>(emprestimoService.devolucao(id), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEditora(@PathVariable long id){
        emprestimoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

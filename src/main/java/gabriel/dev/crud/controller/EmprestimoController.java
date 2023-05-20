package gabriel.dev.crud.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    @GetMapping
    public ResponseEntity<String> listEditora(){
        return new ResponseEntity<>("Retornando Emprestimo" ,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createEditora(){
        return new ResponseEntity<>("Criando Emprestimo", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> replaceEditora(){
        return new ResponseEntity<>("Alterando Emprestimo", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEditora(){
        return new ResponseEntity<>("Deletar Emprestimo", HttpStatus.NO_CONTENT);
    }
}

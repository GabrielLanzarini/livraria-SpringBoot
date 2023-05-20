package gabriel.dev.crud.service;

import gabriel.dev.crud.entities.Emprestimo;
import gabriel.dev.crud.entities.Livro;
import gabriel.dev.crud.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {
    final private EmprestimoRepository emprestimoRepository;
    final private LivroService livroService;

    public List<Emprestimo> listAll(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo listOne(long id){
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo não cadastrado!"));
    }

    public Emprestimo create(long id){
        Livro livro = livroService.listOne(id);
        if(livro.getEmprestado()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O livro já está emprestado!");
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData_emp(new Date());
        livro.setEmprestado(true);
        emprestimo.setLivro(livro);
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolucao(long idEmprestimo){
        Emprestimo emprestimo = listOne(idEmprestimo);
        emprestimo.setData_dev(new Date());
        emprestimo.getLivro().setEmprestado(false);
        return emprestimoRepository.save(emprestimo);
    }

    public void delete(long id){
        emprestimoRepository.delete(listOne(id));
    }
}

package gabriel.dev.crud.mapper;

import gabriel.dev.crud.entities.Emprestimo;
import gabriel.dev.crud.requests.emprestimo.EmprestimoPost;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmprestimoMapper {
    public static final EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);
    public abstract Emprestimo toEmprestimo(EmprestimoPost emprestimoPost);
}

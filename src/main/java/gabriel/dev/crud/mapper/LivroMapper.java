package gabriel.dev.crud.mapper;


import gabriel.dev.crud.entities.Livro;
import gabriel.dev.crud.requests.Livro.LivroPost;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {
    public static final LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);
    public abstract Livro toLivro(LivroPost livroPost);
}

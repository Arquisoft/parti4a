package hello.services;

import hello.domain.Categoria;
import hello.util.exception.CitizenException;

import java.util.List;

/**
 * Created by pelay on 30/03/2017.
 */
public interface CategoryService {

    List<Categoria> findAll();
    Categoria findByNombre(String nombre);
    Categoria findById(Long id);

    public void createCategoria(Categoria categoria) throws CitizenException;

}

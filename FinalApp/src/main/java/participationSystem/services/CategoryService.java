package participationSystem.services;

import java.util.List;

import participationSystem.util.exception.CitizenException;
import repository.domain.Categoria;

/**
 * Created by pelay on 30/03/2017.
 */
public interface CategoryService {

    List<Categoria> findAll();
    Categoria findByNombre(String nombre);
    Categoria findById(Long id);

    public void createCategoria(Categoria categoria) throws CitizenException;

}

package participationSystem.services;

import java.util.List;

import participationSystem.domain.Categoria;
import participationSystem.util.exception.CitizenException;

/**
 * Created by pelay on 30/03/2017.
 */
public interface CategoryService {

    List<Categoria> findAll();
    Categoria findByNombre(String nombre);
    Categoria findById(Long id);

    public void createCategoria(Categoria categoria) throws CitizenException;

}

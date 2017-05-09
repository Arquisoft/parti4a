package es.uniovi.asw.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.Categoria;
import es.uniovi.asw.repository.CategoryRepository;
import es.uniovi.asw.services.CategoryService;
import es.uniovi.asw.util.exception.CitizenException;

import java.util.List;

/**
 * Created by Pelayo García Lartategui on 30/03/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Categoria> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Categoria findByNombre(String nombre) {
        return categoryRepository.findByNombre(nombre);
    }

    @Override
    public Categoria findById(Long id) {
        return categoryRepository.findOne(id);
    }


	@Override
	public void createCategoria(Categoria categoria) throws CitizenException {
		this.categoryRepository.findByNombre(categoria.getNombre());
		if (this.categoryRepository.findByNombre(categoria.getNombre()) == null)
			this.categoryRepository.save(categoria);
		else {
			throw new CitizenException("Ha ocurrido un error al crear la categoría.");

		}
	}
}

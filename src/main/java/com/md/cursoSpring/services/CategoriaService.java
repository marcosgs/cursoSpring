package com.md.cursoSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.md.cursoSpring.domain.Categoria;
import com.md.cursoSpring.repositories.CategoriaRepository;
import com.md.cursoSpring.services.exception.DataIntegrityException;
import com.md.cursoSpring.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Declara as dependencias e instancia elas no Spring
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		this.find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		this.find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos!");
		}

	}
}

package com.md.cursoSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.cursoSpring.domain.Categoria;
import com.md.cursoSpring.repositories.CategoriaRepository;
import com.md.cursoSpring.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Declara as dependencias e instancia elas no Spring
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

}

package com.md.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.md.cursoSpring.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	//Esta interface faz o relacionamento com o banco de dados permitindo a inserção/deleção/atualização de dados usando JPA
}

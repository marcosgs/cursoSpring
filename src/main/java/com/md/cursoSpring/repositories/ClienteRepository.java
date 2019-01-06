package com.md.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.cursoSpring.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

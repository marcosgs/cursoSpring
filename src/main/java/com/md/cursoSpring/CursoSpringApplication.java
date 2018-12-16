package com.md.cursoSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.md.cursoSpring.domain.Categoria;
import com.md.cursoSpring.domain.Produto;
import com.md.cursoSpring.repositories.CategoriaRepository;
import com.md.cursoSpring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	// Command Line Runner server para realizar açoes no load do Spring

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000);
		Produto p2 = new Produto(null, "Impressora", 800);
		Produto p3 = new Produto(null, "Mouse", 80);

		//cat1.setProdutos(Arrays.asList(p1, p2, p3));
		
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

	}
}

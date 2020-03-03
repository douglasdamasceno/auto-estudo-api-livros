package com.livraria.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.livraria.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Livro findById(long id);
}

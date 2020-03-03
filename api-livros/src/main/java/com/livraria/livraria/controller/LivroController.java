package com.livraria.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livraria.entity.Livro;
import com.livraria.livraria.repository.LivroRepository;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping(value="/api")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/livros")
	public List<Livro> listarTodos(){
		return livroRepository.findAll();
	}
	
	@PostMapping("/livros")
	public Livro addLivro(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	@GetMapping("/livros/{id}")
	public Livro findById(@PathVariable(value="id") long id) {
		return livroRepository.findById(id);	
	}
	
	@PutMapping("/livros/{id}")
	public Livro atualizarLivro(@Valid @PathVariable(value="id") long id) {
		return livroRepository.save(livroRepository.findById(id));
	}
	
	@DeleteMapping("/livros/{id}")
	public void deletarLivro(@PathVariable(value="id") long id) {
		livroRepository.delete((livroRepository.findById(id)));	
	}
}

package org.serratec.backend.library.controller;

import java.util.List;

import org.serratec.backend.library.domain.Livro;
import org.serratec.backend.library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> getListaLivros(){
		return livroRepository.findAll();
	}
	
	@GetMapping("/isbn/{isbn}")
	public Livro pesquisarPorISBN(@PathVariable String isbn) {
		return livroRepository.findByIsbn(isbn); 
	}
	
//	@GetMapping("/cat/{titulo}")
//	public List<Livro> ordernarCategoria(@PathVariable String titulo) {
//		return livroRepository.findByTituloOrderByCategoria(titulo);
//	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Livro adicionarLivro(@RequestBody Livro novo_livro) {
		return livroRepository.save(novo_livro);
	}
}


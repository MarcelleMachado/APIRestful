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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping
	@ApiOperation(value="Lista todos os livros", notes="Listagem de livros")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todos os livros"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public List<Livro> getListaLivros(){
		return livroRepository.findAll();
	}
	
	@GetMapping("/isbn/{isbn}")
	@ApiOperation(value="Retorna livro de acordo com ISBN", notes="Busca de livro")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna livro com o ISBN especificado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public Livro pesquisarPorISBN(@PathVariable String isbn) {
		return livroRepository.findByIsbn(isbn); 
	}
	
	@GetMapping("/cat/{titulo}")
	public List<Livro> ordernarCategoria(@PathVariable String titulo) {
		return livroRepository.findByTituloOrderByCategoria(titulo);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value="Insere um novo livro", notes="Inserção de livro")
	@ApiResponses(value= {
	@ApiResponse(code=201, message="Novo livro inserido com sucesso"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public Livro adicionarLivro(@RequestBody Livro novo_livro) {
		return livroRepository.save(novo_livro);
	}
}


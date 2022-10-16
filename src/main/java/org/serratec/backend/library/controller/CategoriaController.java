package org.serratec.backend.library.controller;

import java.util.List;

import org.serratec.backend.library.domain.Categoria;
import org.serratec.backend.library.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	public Categoria inserirCategoria(@RequestBody Categoria nova_categoria) {
		return categoriaRepository.save(nova_categoria);
	}
	
	@GetMapping
	public List<Categoria> getCategories(){
		return categoriaRepository.findAll();
	}
}

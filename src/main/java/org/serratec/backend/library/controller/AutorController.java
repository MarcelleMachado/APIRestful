package org.serratec.backend.library.controller;

import java.util.List;

import org.serratec.backend.library.domain.Autor;
import org.serratec.backend.library.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	AutorRepository autoRep;
	
	@GetMapping
	public List<Autor> getAutores(){
		return autoRep.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Autor postAutor(@RequestBody Autor novo_autor) {
		return autoRep.save(novo_autor);
	}
}

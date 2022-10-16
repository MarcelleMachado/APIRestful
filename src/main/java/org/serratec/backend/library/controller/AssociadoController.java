package org.serratec.backend.library.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.library.domain.Associado;
import org.serratec.backend.library.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/associados")
public class AssociadoController {
	@Autowired
	AssociadoRepository associadoRepository;
	@GetMapping
	public List<Associado> listarAssociados(){
		return associadoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Associado adicionarAssociado(@Valid @RequestBody Associado novo_associado) {
		return associadoRepository.save(novo_associado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerAssociado(@PathVariable Long id){
		Optional<Associado> associado = associadoRepository.findById(id);
		if(associado == null) {
			return ResponseEntity.notFound().build();
		} 
		associadoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

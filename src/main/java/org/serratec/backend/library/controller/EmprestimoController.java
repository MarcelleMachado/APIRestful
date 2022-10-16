package org.serratec.backend.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.library.domain.Emprestimo;
import org.serratec.backend.library.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	@GetMapping
	public List<Emprestimo> listarEmprestimos(){
		return emprestimoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Emprestimo adicionarEmprestimo(@Valid @RequestBody Emprestimo novo_emprestimo) {
		return emprestimoRepository.save(novo_emprestimo);
	}
}

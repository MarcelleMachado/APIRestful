package org.serratec.backend.library.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Long id;
	@Size(max = 50)
	@NotNull
	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToMany
	@JoinTable(name="autor_livro", 
	joinColumns = @JoinColumn(name="id_autor"),
	inverseJoinColumns = @JoinColumn(name="id_livro"))
	private List<Livro> livros;
	
	
	public Autor(Long id, @Size(max = 50) @NotNull String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Autor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

package org.serratec.backend.library.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
	private Long id;
	@Size(max = 40)
	@NotNull
	@Column(length = 40, nullable = false)
	private String titulo;	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="autor_livro", 
	joinColumns = @JoinColumn(name="id_livro"),
	inverseJoinColumns = @JoinColumn(name="id_autor"))
	private Set<Autor> autores;
	@Size(max = 20)
	@NotNull
	@Column(length = 20, nullable = false, unique = true)
	private String isbn;
	@OneToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	@Column(name = "data_publicacao")
	private Date dataPublicacao;
//	@OneToMany(mappedBy="idLivro")
//	private Set<EmprestimoLivro> comentario;
//	
	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

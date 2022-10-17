package org.serratec.backend.library.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class EmprestimoLivro {
	
	@EmbeddedId
	EmprestimoLivroKey id;
	
	@ManyToOne
	@MapsId("id_emprestimo")
	@JoinColumn(name="id_emprestimo")
	Emprestimo idEmprestimo;
	
	@ManyToOne
	@MapsId("id_livro")
	@JoinColumn(name="id_livro")
	Livro idLivro;
	
	@Column(length=40)
	private String observacoesAtoEmprestimo;

	public EmprestimoLivroKey getId() {
		return id;
	}

	public void setId(EmprestimoLivroKey id) {
		this.id = id;
	}

	public Emprestimo getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Emprestimo idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Livro getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Livro idLivro) {
		this.idLivro = idLivro;
	}

	public String getObservacoesAtoEmprestimo() {
		return observacoesAtoEmprestimo;
	}

	public void setObservacoesAtoEmprestimo(String observacoesAtoEmprestimo) {
		this.observacoesAtoEmprestimo = observacoesAtoEmprestimo;
	}
	
	
}

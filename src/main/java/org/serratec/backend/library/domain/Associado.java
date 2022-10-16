package org.serratec.backend.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="associado")
public class Associado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_associado")
	private Long id;
	@Size(max = 50)
	@NotNull
	@Column(length = 50, nullable = false)
	private String nome;
	@Size(max = 15)
	@NotNull
	@Column(length = 15, nullable = false)
	private String telefone;
	@Size(max = 11)
	@NotNull
	@Column(length = 11, nullable = false, unique = true)
	private String cpf; //ALTERAR PARA SER UNIQUE
	@Size(max = 80)
	@NotNull
	@Column(length = 80, nullable = false)
	private String logradouro;
	@Size(max = 10)
	@NotNull
	@Column(length = 10, nullable = false)
	private String numero;
	@Size(max = 30)
	@Column(length = 30)
	private String complemento;
	@Size(max = 50)
	@NotNull
	@Column(length = 50, nullable = false)
	private String bairro;
	@Size(max = 50)
	@NotNull
	@Column(length = 50, nullable = false)
	private String cidade;
	@Size(max = 2)
	@NotNull
	@Column(length = 2, nullable = false)
	private String estado;
	
	public Associado() {
		super();
	}

	public Associado(Long id, @Size(max = 50) @NotNull String nome, @Size(max = 15) @NotNull String telefone,
			@Size(max = 11) @NotNull String cpf, @Size(max = 80) @NotNull String logradouro,
			@Size(max = 10) @NotNull String numero, @Size(max = 30) @NotNull String complemento,
			@Size(max = 50) @NotNull String bairro, @Size(max = 50) @NotNull String cidade,
			@Size(max = 2) @NotNull String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}

package model;


import java.util.Date;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private String sexo;
	private String celular;

	//Gets//
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getSexo() {
		return sexo;
	}

	public String getCelular() {
		return celular;
	}

	// Sets//
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

}

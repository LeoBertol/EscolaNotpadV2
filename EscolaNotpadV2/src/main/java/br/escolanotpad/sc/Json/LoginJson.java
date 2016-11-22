package br.escolanotpad.sc.Json;

public class LoginJson {

	private boolean sucesso;
	private Long id; 
	private String nome;
	private String email;
	public String getEmail() {
		return email;
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	private String regra;

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

}

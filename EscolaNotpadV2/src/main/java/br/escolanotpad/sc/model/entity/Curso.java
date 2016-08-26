package br.escolanotpad.sc.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Curso {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private float mensalidade;
	private Date dataDeInicioInscricoes;
	private Date dataDeTerminoInscricoes;
	
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
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getMensalidade() {
		return mensalidade;
	}
	
	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public Date getDataDeInicioInscricoes() {
		return dataDeInicioInscricoes;
	}
	
	public void setDataDeInicioInscricoes(Date dataDeInicioInscricoes) {
		this.dataDeInicioInscricoes = dataDeInicioInscricoes;
	}
	
	public Date getDataDeTerminoInscricoes() {
		return dataDeTerminoInscricoes;
	}
	
	public void setDataDeTerminoInscricoes(Date dataDeTerminoInscricoes) {
		this.dataDeTerminoInscricoes = dataDeTerminoInscricoes;
	}	

}

package br.escolanotpad.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Prova {
	@Id
	@GeneratedValue
	private Long id;
	private String tituloProva;
	private  Date dataProva;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@ManyToOne
	private Turma turma;
	@ManyToMany
	private List<Pergunta> perguntasProva;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTituloProva() {
		return tituloProva;
	}
	public void setTituloProva(String tituloProva) {
		this.tituloProva = tituloProva;
	}
	public Date getDataProva() {
		return dataProva;
	}
	public void setDataProva(Date dataProva) {
		this.dataProva = dataProva;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<Pergunta> getPerguntasProva() {
		return perguntasProva;
	}
	public void setPerguntasProva(List<Pergunta> perguntasProva) {
		this.perguntasProva = perguntasProva;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj){
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (!(obj instanceof Prova))
	return false;
	Prova other = (Prova) obj;
	if (id == null){
	if (other.id != null)
	return false;
	} else if (!id.equals(other.id))
	return false;
	return true;
	}
	
}

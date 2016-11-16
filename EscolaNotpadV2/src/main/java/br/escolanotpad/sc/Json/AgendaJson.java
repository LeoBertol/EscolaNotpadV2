package br.escolanotpad.sc.Json;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.escolanotpad.sc.model.entity.Ambiente;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class AgendaJson {
	
	private Long id;
	private String professorNome;
	private String ambienteNome;
	private String turmaNome;
	private Date data;
	private Date inicioDaAula;
	private Date fimDaAula;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfessorNome() {
		return professorNome;
	}
	public void setProfessorNome(String professorNome) {
		this.professorNome = professorNome;
	}
	public String getAmbienteNome() {
		return ambienteNome;
	}
	public void setAmbienteNome(String ambienteNome) {
		this.ambienteNome = ambienteNome;
	}
	public String getTurmaNome() {
		return turmaNome;
	}
	public void setTurmaNome(String turmaNome) {
		this.turmaNome = turmaNome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getInicioDaAula() {
		return inicioDaAula;
	}
	public void setInicioDaAula(Date inicioDaAula) {
		this.inicioDaAula = inicioDaAula;
	}
	public Date getFimDaAula() {
		return fimDaAula;
	}
	public void setFimDaAula(Date fimDaAula) {
		this.fimDaAula = fimDaAula;
	}
	
	

}

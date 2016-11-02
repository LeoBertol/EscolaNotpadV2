package br.escolanotpad.sc.model.entity;

import java.sql.Time;
import java.util.Date;

import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mysql.fabric.xmlrpc.base.Data;

@ViewScoped
@Entity
public class Agenda {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Usuario professorResponsavel;
	@ManyToOne
	private Ambiente ambiente;
	@ManyToOne
	private Turma turma;
	private Date data;
	@Temporal(TemporalType.TIME)
	private Date inicioDaAula;
	@Temporal(TemporalType.TIME)
	private Date fimDaAula;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getProfessorResponsavel() {
		return professorResponsavel;
	}
	public void setProfessorResponsavel(Usuario professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
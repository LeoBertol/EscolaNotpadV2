package br.escolanotpad.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@ManyToOne
	private Usuario professor;
	@ManyToOne
	private Curso curso;
	@ManyToMany
	private List<Usuario> alunosTurma;
	@OneToMany(mappedBy = "turma")
	private List<Arquivo> listaArquivos;
	
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
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Usuario> getAlunosTurma() {
		return alunosTurma;
	}
	public void setAlunosTurma(List<Usuario> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}
	
	public List<Arquivo> getListaArquivos() {
		return listaArquivos;
	}
	public void setListaArquivos(List<Arquivo> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alunosTurma == null) ? 0 : alunosTurma.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((listaArquivos == null) ? 0 : listaArquivos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((professor == null) ? 0 : professor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turma other = (Turma) obj;
		if (alunosTurma == null) {
			if (other.alunosTurma != null) {
				return false;
			}
		} else if (!alunosTurma.equals(other.alunosTurma)) {
			return false;
		}
		if (curso == null) {
			if (other.curso != null) {
				return false;
			}
		} else if (!curso.equals(other.curso)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (listaArquivos == null) {
			if (other.listaArquivos != null) {
				return false;
			}
		} else if (!listaArquivos.equals(other.listaArquivos)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (professor == null) {
			if (other.professor != null) {
				return false;
			}
		} else if (!professor.equals(other.professor)) {
			return false;
		}
		return true;
	}
	
	
	
	
}

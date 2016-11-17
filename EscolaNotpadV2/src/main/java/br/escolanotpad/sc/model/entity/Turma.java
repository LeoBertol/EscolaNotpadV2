package br.escolanotpad.sc.model.entity;

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
			
	public Turma() {
		
	}
	
	public Turma(Long id, String nome, Usuario professor, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
		this.curso = curso;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}

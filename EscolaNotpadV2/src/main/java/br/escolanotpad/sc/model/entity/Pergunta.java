package br.escolanotpad.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta {
	
	@Id
	@GeneratedValue
	private Long id;
	private String tituloPergunta;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Resposta> alternativasCorreta;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTituloPergunta() {
		return tituloPergunta;
	}
	public void setTituloPergunta(String tituloPergunta) {
		this.tituloPergunta = tituloPergunta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Resposta> getAlternativasCorreta() {
		return alternativasCorreta;
	}
	public void setAlternativasCorreta(List<Resposta> alternativasCorreta) {
		this.alternativasCorreta = alternativasCorreta;
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
		Pergunta other = (Pergunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

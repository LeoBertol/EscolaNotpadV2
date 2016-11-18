package br.escolanotpad.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Curso;

public class CursoDAO extends DAO{

	public CursoDAO(){
		
	}
	
	public CursoDAO(EntityManager entityManager) {
		super(entityManager);
	}
		
	public void salvar(Curso curso){
		if(curso.getId() == null){
			getEM().persist(curso);
		}else{
			getEM().merge(curso);
		}		
	}
	
	public Curso buscarPorId(Long id){
		return getEM().find(Curso.class, id);
	}
	
	public List<Curso> listar(){
		Query query = getEM().createQuery("From Curso order by id desc", Curso.class);
		return query.getResultList();
	}
		
	public void excluir(Long id){
		Curso curso = getEM().getReference(Curso.class, id);
		getEM().remove(curso);
	}
	
}

package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Prova;
import br.escolanotpad.sc.model.entity.Turma;

public class ProvaDAO extends DAO{

	public void salvar(Prova prova) throws SQLException{
		getEM().merge(prova);
	}
	
	public Prova buscarPorId(Long id){
		return getEM().find(Prova.class, id);
	}
	
	public List<Prova> listar(){
		Query query = getEM().createQuery("From Prova order by id desc", Prova.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Prova prova = getEM().getReference(Prova.class, id);
		getEM().remove(prova);
	}
	
}

package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Ambiente;

public class AmbienteDAO extends DAO{
	
	public void salvar(Ambiente ambiente) throws SQLException{
		getEM().merge(ambiente);
	}
	
	public Ambiente buscarPorId(Long id){
		return getEM().find(Ambiente.class, id);
	}
	
	public List<Ambiente> listar(){
		Query query = getEM().createQuery("From Ambiente order by id desc", Ambiente.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Ambiente ambiente = getEM().getReference(Ambiente.class, id);
		getEM().remove(ambiente);
	}

}

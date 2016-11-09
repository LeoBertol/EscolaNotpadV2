package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Arquivo;
import br.escolanotpad.sc.model.entity.Turma;

public class ArquivoDAO extends DAO{
	
	public void salvar(Arquivo arquivo){
		if(arquivo.getId() == null){
			getEM().persist(arquivo);
		}else{
			getEM().merge(arquivo);
		}
	}
	
	public Arquivo buscarPorId(Long id){
		return getEM().find(Arquivo.class, id);
	}
		
	public List<Arquivo> listar(){
		Query query = getEM().createQuery("From Arquivo order by id desc", Arquivo.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Arquivo arquivo = getEM().getReference(Arquivo.class, id);
		getEM().remove(arquivo);
	}

}

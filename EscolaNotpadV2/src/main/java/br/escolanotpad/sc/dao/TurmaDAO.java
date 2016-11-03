package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class TurmaDAO extends DAO{
		
	public void salvar(Turma turma){
		if(turma.getId() == null){
			getEM().persist(turma);
		}else{
			getEM().merge(turma);
		}
	}
	
	public Turma buscarPorId(Long id){
		return getEM().find(Turma.class, id);
	}
	
	public List<Turma> listar(){
		Query query = getEM().createQuery("From Turma order by id desc", Turma.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Turma turma = getEM().getReference(Turma.class, id);
		getEM().remove(turma);
	}

	public List<Turma> listarTurmaPorUsuario(Long usuarioLogado) {
		Query query = getEM().createQuery(
				"From Turma t Where t.professor.id = :idUsuario"
				, Turma.class);	
		query.setParameter("idUsuario", usuarioLogado);
		return query.getResultList();
	}
	
}

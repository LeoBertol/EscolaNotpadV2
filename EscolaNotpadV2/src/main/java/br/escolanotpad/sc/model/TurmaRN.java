package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.TurmaDAO;
import br.escolanotpad.sc.model.entity.Turma;

public class TurmaRN {
	
	private TurmaDAO dao;
	
	public TurmaRN(){
		dao = new TurmaDAO();
	}
		
	public List<Turma> listar(){
		return dao.listar();
	}
	
	public void salvar(Turma turma) throws SQLException{
		dao.salvar(turma);
	}

	public Turma buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	
	
	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Turma> listarTurmaPorUsuario(Long usuarioLogado) {
		return dao.listarTurmaPorUsuario(usuarioLogado);
	}
	
	
}

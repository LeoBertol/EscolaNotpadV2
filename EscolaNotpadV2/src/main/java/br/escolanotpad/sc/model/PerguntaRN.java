package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.PerguntaDAO;
import br.escolanotpad.sc.model.entity.Pergunta;

public class PerguntaRN {
	
	private PerguntaDAO dao;
	
	public PerguntaRN(){
		dao = new PerguntaDAO();
	}

	public void salvar(Pergunta pergunta) throws SQLException{
		dao.salvar(pergunta);
	}

	public Pergunta buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Pergunta> listar(){
		return dao.listar();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
	
}

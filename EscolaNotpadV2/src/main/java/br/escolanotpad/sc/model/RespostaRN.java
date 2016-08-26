package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.RespostaDAO;
import br.escolanotpad.sc.model.entity.Resposta;

public class RespostaRN {
	
	private RespostaDAO dao;
	
	public RespostaRN(){
		dao = new RespostaDAO();
	}

	public void salvar(Resposta resposta) throws SQLException{
		dao.salvar(resposta);
	}

	public Resposta buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Resposta> listar(){
		return dao.listar();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Resposta> buscarPorIdDaPergunta(Long id){
		return dao.buscarPorIdDaPergunta(id);
	}
	
}

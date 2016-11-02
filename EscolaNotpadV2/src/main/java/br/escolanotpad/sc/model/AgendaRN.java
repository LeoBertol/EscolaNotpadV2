package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import java.util.Date;
import br.escolanotpad.sc.dao.AgendaDAO;
import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.entity.Ambiente;
import br.escolanotpad.sc.model.entity.Usuario;

public class AgendaRN {

	private AgendaDAO dao;
	
	public AgendaRN(){
		dao = new AgendaDAO();
	}
	
	public List<Agenda> listar(){
		return dao.listar();
	}
	
	public void salvar(Agenda agenda) throws SQLException{
		dao.salvar(agenda);
	}
	
	public Agenda buscarPorId(Long id){
		return dao.buscarPorId(id);
	}
	
	public void excluir(Long id){
		dao.excluir(id);
	}
	
	public List<Usuario> listarParaAutoComplete(String busca) {
		return dao.listarParaAutoComplete(busca);
	}

	public List<Agenda> listaAgendaPorTurma(String busca) {
		return dao.listarAgendasPorTurma(busca);
	}
	
	
	
	public List<Agenda> listaAgendaPorProfessor(String professorId) {
		return dao.listaAgendaPorProfessor(professorId);
	}
	
	public List<Agenda> buscarPorData(Date busca){
		return dao.buscarPorData(busca);
	}

	public List<Agenda> buscarPorAmbiente(Long buscaAmbiente, Date buscaData) {
		return dao.buscarPorAmbiente(buscaAmbiente, buscaData);
	}

	public List<Agenda> buscarPorHorario(Long buscaAmbiente, Date buscaData, Date buscaInicioDaAula, Date buscaFimDaAula) {
		return dao.buscarPorHorario(buscaAmbiente, buscaData, buscaInicioDaAula, buscaFimDaAula);
	}

	
	

	
	
	
	
}

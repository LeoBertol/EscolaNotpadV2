package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.escolanotpad.sc.commons.JpaUtilTest;
import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.entity.Ambiente;
import br.escolanotpad.sc.model.entity.Curso;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class AgendaDAOTest {
	
	private EntityManager entityManager;

	@BeforeClass
	public static void initClass() {
		JpaUtilTest.getInstancia().initEntityManagerFactory();
	}
	
	@AfterClass
	public static void finishClass() {
		JpaUtilTest.getInstancia().closeEntityManagerFactory();
	}

	@Before
	public void initTest() {
		entityManager = JpaUtilTest.getInstancia().getEntityManager();
	}

	@After
	public void finishTest() {
		JpaUtilTest.getInstancia().closeEntityManager();
	}

	@Test
	public void entityManagerByUsuarioDaoIsNotNullTest() {
		Assert.assertNotNull(entityManager);
	}

	@Test
	public void entityManagerByUsuarioDaoIsNullTest() {
		entityManager = null;
		Assert.assertNull(entityManager);
	}
	
	@Test
	public void construtorVaziuTest(){
		AgendaDAO dao = new AgendaDAO();
	}
	
	@Test
	public void dao2(){
		TurmaDAO dao2 = new TurmaDAO();
	}
	
	@Test
	public void salvarAgendaTest() throws SQLException {
		AgendaDAO dao = new AgendaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Ambiente ambiente = new Ambiente();
		Turma turma = new Turma();
		Agenda agendaSave = new Agenda(1l, usuarioProfessor, ambiente, turma, new Date(),  new Date(), new Date());
				
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(agendaSave);
		JpaUtilTest.getInstancia().endSession();
						
	}
	
	@Test
	public void salvarAgendaComIdNuloTest() throws SQLException {
		AgendaDAO dao = new AgendaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Ambiente ambiente = new Ambiente();
		Turma turma = new Turma();
		Agenda agendaSave = new Agenda(null, usuarioProfessor, ambiente, turma, new Date(),  new Date(), new Date());
				
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(agendaSave);
		JpaUtilTest.getInstancia().endSession();
						
	}
	
	@Test@Ignore
	public void excluirTurmaTest() throws SQLException {
		AgendaDAO dao = new AgendaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Ambiente ambiente = new Ambiente();
		Turma turma = new Turma();
		Agenda agendaSave = new Agenda(2l, usuarioProfessor, ambiente, turma, new Date(),  new Date(), new Date());
				
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(agendaSave);
		dao.excluir(1l);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void listarAgendaTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.listar();
	}
	
	@Test
	public void buscarPorIdTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.buscarPorId(2l);
	}
	
	@Test
	public void buscarPorDataTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.buscarPorData(new Date());
	}
	
	@Test
	public void listarAgendaPorTurmaTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.listarAgendasPorTurma("Turma Teste");
	}

	@Test
	public void listarAgendaPorProfessorTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.listaAgendaPorProfessor(null);
	}
	
	@Test
	public void listarParaAutoCompleteTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.listarParaAutoComplete("Teste");
	}
	
	@Test@Ignore
	public void listarAgendaPorAluno(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.listaAgendaPorAluno(null);
	}
	
	@Test
	public void buscarPorAmbienteTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.buscarPorAmbiente(1l, new Date());
	}
	
	@Test
	public void buscarPorHorarioTest(){
		AgendaDAO dao = new AgendaDAO(entityManager);
		dao.buscarPorHorario(null, new Date(), new Date(), new Date());
	}
	
}

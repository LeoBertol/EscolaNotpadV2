package br.escolanotpad.sc.dao;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.escolanotpad.sc.commons.JpaUtilTest;
import br.escolanotpad.sc.model.entity.Curso;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class TurmaDAOTest {
	
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
		TurmaDAO dao = new TurmaDAO();
	}
	
	@Test
	public void salvarTurmaTest() {
		TurmaDAO dao = new TurmaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Curso cursoTeste = new Curso();
		Turma turmaSave = new Turma(1l, "Turma Teste", usuarioProfessor, cursoTeste);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(turmaSave);
		JpaUtilTest.getInstancia().endSession();
						
	}
	
	@Test
	public void salvarTurmaComIdNuloTest() {
		TurmaDAO dao = new TurmaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Curso cursoTeste = new Curso();
		Turma turmaSave = new Turma(null, "Turma Teste Com Id Nulo", usuarioProfessor, cursoTeste);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(turmaSave);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test@Ignore
	public void excluirTurmaTest() {
		TurmaDAO dao = new TurmaDAO(entityManager);
		Usuario usuarioProfessor = new Usuario();
		Curso cursoTeste = new Curso();
		Turma turmaSave = new Turma(2l, "Turma Teste", usuarioProfessor, cursoTeste);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(turmaSave);
		dao.excluir(5l);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void listarTurmaTest(){
		TurmaDAO dao = new TurmaDAO(entityManager);
		dao.listar();
	}
	
	@Test
	public void listarTurmaPorUsuarioTest(){
		TurmaDAO dao = new TurmaDAO(entityManager);
		dao.listarTurmaPorUsuario(1l);
	}
	
	@Test
	public void buscarPorIdTest(){
		TurmaDAO dao = new TurmaDAO(entityManager);
		dao.buscarPorId(1l);
	}
	
}

package br.escolanotpad.sc.dao;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.escolanotpad.sc.commons.JpaUtilTest;
import br.escolanotpad.sc.model.entity.Ambiente;

public class AmbienteDAOTest {
	
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
		AmbienteDAO dao = new AmbienteDAO();
	}
		
	@Test
	public void salvarAmbienteTest() {
		AmbienteDAO dao = new AmbienteDAO(entityManager);
		Ambiente ambienteSave = new Ambiente(1l, "Ambiente Teste", "Descricao teste", 100);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(ambienteSave);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void salvarAmbienteComIdNuloTest() {
		AmbienteDAO dao = new AmbienteDAO(entityManager);
		Ambiente ambienteSave = new Ambiente(null, "Ambiente Teste", "Descricao teste", 100);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(ambienteSave);
		JpaUtilTest.getInstancia().endSession();						
	}
			
	@Test
	public void excluirAmbienteTest() {
		AmbienteDAO dao = new AmbienteDAO(entityManager);
		Ambiente ambienteSave = new Ambiente(2l, "Ambiente Teste", "Descricao teste", 100);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(ambienteSave);		
		JpaUtilTest.getInstancia().endSession();			
		
		JpaUtilTest.getInstancia().beginSession();
		dao.excluir(1l);;
		JpaUtilTest.getInstancia().endSession();	
	}
			
	@Test
	public void listarAmbientesTest(){
		AmbienteDAO dao = new AmbienteDAO(entityManager);
		dao.listar();
	}	
	
	@Test
	public void buscarPorIdTest(){
		AmbienteDAO dao = new AmbienteDAO(entityManager);
		dao.buscarPorId(2l);
	}	
	
}

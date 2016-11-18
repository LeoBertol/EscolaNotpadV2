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

public class CursoDAOTest {
	
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
		CursoDAO dao = new CursoDAO();
	}
	
	@Test
	public void salvarCursoTest(){
		CursoDAO dao = new CursoDAO(entityManager);
		Curso cursoSave = new Curso(1l, "Curso Teste", "Descricao", 120);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(cursoSave);
		JpaUtilTest.getInstancia().endSession();												
	}	
	
	@Test
	public void salvarCursoComIdNuloTest(){
		CursoDAO dao = new CursoDAO(entityManager);
		Curso cursoSave = new Curso(null, "Curso Teste Id Nulo", "Descricao Teste", 120);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(cursoSave);
		JpaUtilTest.getInstancia().endSession();			
		
	}
	
	@Test
	public void excluirCursoTest(){
		CursoDAO dao = new CursoDAO(entityManager);
		Curso cursoSave = new Curso(2l, "Curso Excluir", "Descricao Teste", 120f);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(cursoSave);
		dao.excluir(2l);
		JpaUtilTest.getInstancia().endSession();	
	}
	
	@Test
	public void listarCursosTest(){
		CursoDAO dao = new CursoDAO(entityManager);
		dao.listar();
	}	
	
	@Test
	public void buscarCursoPorIdTest(){
		CursoDAO dao = new CursoDAO(entityManager);
		dao.buscarPorId(1l);
	}	
	
}

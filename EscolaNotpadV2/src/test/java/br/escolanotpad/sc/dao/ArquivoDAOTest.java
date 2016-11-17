package br.escolanotpad.sc.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.escolanotpad.sc.commons.JpaUtilTest;
import br.escolanotpad.sc.model.entity.Arquivo;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class ArquivoDAOTest {
	
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
		ArquivoDAO dao = new ArquivoDAO();
	}
	
	@Test
	public void salvarArquivoTest() {
		ArquivoDAO dao = new ArquivoDAO(entityManager);
		Usuario usuario = new Usuario();
		Turma turma = new Turma();		
		Arquivo arquivoSave = new Arquivo(1l, "Arquivo", "Nome Arquivo", "Descricao Arquivo", new Date(), turma, usuario);
				
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(arquivoSave);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void salvarArquivoComIdNuloTest() {
		ArquivoDAO dao = new ArquivoDAO(entityManager);
		Usuario usuario = new Usuario();
		Turma turma = new Turma();		
		Arquivo arquivoSave = new Arquivo(null, "Arquivo", "Nome Arquivo", "Descricao Arquivo", new Date(), turma, usuario);
				
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(arquivoSave);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void excluirArquivoTest() {
		ArquivoDAO dao = new ArquivoDAO(entityManager);
		Usuario usuario = new Usuario();
		Turma turma = new Turma();		
		Arquivo arquivoSave = new Arquivo(2l, "Arquivo", "Nome Arquivo", "Descricao Arquivo", new Date(), turma, usuario);
				
		JpaUtilTest.getInstancia().beginSession();		
		dao.salvar(arquivoSave);
		dao.excluir(2l);
		JpaUtilTest.getInstancia().endSession();						
	}
	
	@Test
	public void listarArquivoTest(){
		ArquivoDAO dao = new ArquivoDAO(entityManager);
		dao.listar();
	}
	
	@Test
	public void buscarPorIdTest(){
		ArquivoDAO dao = new ArquivoDAO(entityManager);
		dao.buscarPorId(1l);
	}
	
}

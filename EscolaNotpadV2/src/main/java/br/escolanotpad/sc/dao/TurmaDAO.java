package br.escolanotpad.sc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Curso;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

public class TurmaDAO extends DAO{
	
	public TurmaDAO(){
		
	}
	
	public TurmaDAO(EntityManager entityManager) {
		super(entityManager);
	}
		
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

	public List<Turma> listarTurmaPorProfessor(Long usuarioLogado) {
		Query query = getEM().createNativeQuery("select t.nome as turma, c.nome as curso from Turma t inner join Curso c ON (t.curso_id = c.id) where t.professor_id = :idUsuario");
		query.setParameter("idUsuario", usuarioLogado);
		
		List<Object[]> turmas = query.getResultList();
		
		List<Turma> turmasList = new ArrayList<Turma>();
		for (Object[] o : turmas) {
			Turma t = new Turma();
			t.setNome((String) o[0]);
			t.setCurso(new Curso());
			t.getCurso().setNome((String) o[1]);
			turmasList.add(t);
		}
		return turmasList;
	}
		
	public List<Turma> listarTurmaPorAluno(Long usuarioLogado) {
		Query query = getEM().createNativeQuery("select t.nome as turma, u.nome as professor, c.nome as curso from Turma t inner join Turma_Usuario tu ON (t.id = tu.turma_id) inner join usuario u ON (t.professor_id = u.id) inner join curso c ON (t.curso_id = c.id) where tu.alunosTurma_id = :idUsuario");
		query.setParameter("idUsuario", usuarioLogado);
		
		List<Object[]> turmas = query.getResultList();
		
		List<Turma> turmasList = new ArrayList<Turma>();
		for (Object[] o : turmas) {
			Turma t = new Turma();
			t.setNome((String) o[0]);
			t.setProfessor(new Usuario());
			t.getProfessor().setNome((String) o[1]);
			t.setCurso(new Curso());
			t.getCurso().setNome((String) o[2]);
			turmasList.add(t);
		}
		return turmasList;
	}
	
}

package br.escolanotpad.sc.dao;

import javax.persistence.EntityManager;

import br.escolanotpad.sc.commons.JpaUtil;


public abstract class DAO {
	
	public DAO(){
		super();
	}

	protected EntityManager getEM(){
			EntityManager em = JpaUtil.getEntityManager();
			return em;
	}
	
}

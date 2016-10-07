package br.escolanotpad.sc.dao;

public abstract class DaoFactory {
	
	private static UsuarioDAOTest usuarioDao;
	private static RegraDAO regraDAO;
	
	public static UsuarioDAOTest getUsuarioDao(){
		if (usuarioDao == null){
			usuarioDao = new UsuarioDAOTest();
		}
		return usuarioDao;
	}
	
	public static RegraDAO getRegraDAO(){
		if (regraDAO == null){
			regraDAO = new RegraDAO();
		}
		return regraDAO;
	}
	
}

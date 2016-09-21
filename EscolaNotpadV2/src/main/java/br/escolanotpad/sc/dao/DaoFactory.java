package br.escolanotpad.sc.dao;

public abstract class DaoFactory {
	
	private static UsuarioDAO usuarioDao;
	private static RegraDAO regraDAO;
	
	public static UsuarioDAO getUsuarioDao(){
		if (usuarioDao == null){
			usuarioDao = new UsuarioDAO();
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

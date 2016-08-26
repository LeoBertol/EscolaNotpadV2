package br.escolanotpad.sc.dao;

public abstract class DaoFactory {
	
	private static UsuarioDAO usuarioDao;
	
	public static UsuarioDAO getUsuarioDao(){
		if (usuarioDao == null){
			usuarioDao = new UsuarioDAO();
		}
		return usuarioDao;
	}
	
}

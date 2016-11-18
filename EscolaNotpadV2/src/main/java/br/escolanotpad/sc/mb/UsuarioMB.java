package br.escolanotpad.sc.mb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.Part;

import br.escolanotpad.sc.commons.MailUtil;
import br.escolanotpad.sc.commons.UploadUtil;
import br.escolanotpad.sc.commons.Utils;
import br.escolanotpad.sc.model.UsuarioRN;
import br.escolanotpad.sc.model.entity.Usuario;

@ManagedBean
public class UsuarioMB {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Long editarId;
	private Part uploadedFotoPerfil;
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaProfessores;
	private List<Usuario> listaAlunos;
	private List<Usuario> listaAlunosCadastrados;
	private int tamanho;
	private String descricao;
	
	@PostConstruct
	public void depoisDeConstruir(){
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Usuario> getListaUsuarios() {
		if(listaUsuarios == null){
			listaUsuarios = usuarioRN.listarUsuarios();
		}
		return listaUsuarios;
	}

	public List<Usuario> getListaAlunos() {
		if(listaAlunos == null){
			listaAlunos = usuarioRN.listarAlunos();
		}
		return listaAlunos;
	}
	
	public List<Usuario> getListaProfessores() {
		if(listaProfessores == null){
			listaProfessores = usuarioRN.listarProfessores();
		}
		return listaProfessores;
	}
		
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	
	public void setListaAlunos(List<Usuario> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	public Part getUploadedFotoPerfil() {
		return uploadedFotoPerfil;
	}

	public void setUploadedFotoPerfil(Part uploadedFotoPerfil) {
		this.uploadedFotoPerfil = uploadedFotoPerfil;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void carregarUsuario(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		usuario = usuarioRN.buscarPorId(editarId);
	}
	
	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public String excluir(String id){
				
		Long idExcluir = Long.parseLong(id);
		Usuario usuario = usuarioRN.buscarPorId(idExcluir);		
		UploadUtil.removerArquivo(usuario.getFotoPerfil());
		
		usuarioRN.excluir(idExcluir);
		listaUsuarios = null;
		return "/admin/listaUsuario";
	}
	
	public String salvar() throws SQLException{
		try{
			String nomeFotoPerfil = UploadUtil.moverArquivo(uploadedFotoPerfil, usuario.getFotoPerfil());
			usuario.setFotoPerfil(nomeFotoPerfil);	
			String hash = Utils.senhaToSha256(usuario.getSenha());
			usuario.setSenha(hash);									
			usuarioRN.salvar(usuario);
			listaUsuarios = null;
			
			try{
			MailUtil.enviarEmail(usuario.getEmail(), "Cadastro Escola NotPad", 
					"Seja Bem-Vindo(a) " + usuario.getNome() + ", \nVocê foi cadastrado em nossa escola, Sua senha para realizar o login: " + usuario.getSenha());
			}catch (Exception e){
				return "/admin/listaUsuario";
			}
						
			return "/admin/listaUsuario";
			
		} catch(IOException e){
			e.printStackTrace();
			return "";
		}
	}	
	
	public String converterPerfilLayout(String perfil){
		if(perfil.equals("ROLE_ADMINISTRADOR")){
			perfil = "Administrador";
		}else if(perfil.equals("ROLE_ALUNO")){
			perfil = "Aluno";
		}else if(perfil.equals("ROLE_PROFESSOR")){
			perfil = "Professor";
		}
		return perfil;		
	}
	
	public String alunosCadastrados(){
		if(listaAlunosCadastrados == null){
			if(usuario.getPerfil().equals("TODOS_OS_USUARIOS")){
				listaAlunosCadastrados = usuarioRN.listarUsuarios();				
				tamanho = listaAlunosCadastrados.size();				
				descricao = "Usuários cadastrados: ";
			}else if(usuario.getPerfil().equals("ROLE_ADMINISTRADOR")){
				listaAlunosCadastrados = usuarioRN.listarAdministradores();				
				tamanho = listaAlunosCadastrados.size();
				descricao = "Usuários com perfil de administrador: ";
			}else if(usuario.getPerfil().equals("ROLE_ALUNO")){
				listaAlunosCadastrados = usuarioRN.listarAlunos();
				tamanho = listaAlunosCadastrados.size();
				descricao = "Usuários com perfil de aluno: ";
			}else if(usuario.getPerfil().equals("ROLE_PROFESSOR")){
				listaAlunosCadastrados = usuarioRN.listarProfessores();
				tamanho = listaAlunosCadastrados.size();
				descricao = "Usuários com perfil de professor: ";
			}
		
		}
		return "/admin/resultadoRelatorioUsuarios";
	}

	public String selecaoRelatoriosUsuario(){
		return "/admin/selecaoRelatoriosUsuario";
	}
	
	public String voltarRelatorios(){
		return "/admin/relatorios";
	}

	public List<Usuario> getListaAlunosCadastrados() {
		if(listaAlunos == null){
			listaAlunos = usuarioRN.listarAlunos();
		}
		return listaAlunosCadastrados;
	}

	public void setListaAlunosCadastrados(List<Usuario> listaAlunosCadastrados) {
		this.listaAlunosCadastrados = listaAlunosCadastrados;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}

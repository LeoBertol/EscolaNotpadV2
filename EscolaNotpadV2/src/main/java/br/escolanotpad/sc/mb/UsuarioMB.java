package br.escolanotpad.sc.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.Part;

import br.escolanotpad.sc.commons.UploadUtil;
import br.escolanotpad.sc.model.UsuarioRN;
import br.escolanotpad.sc.model.entity.Perfil;
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
	
	/*public List<Usuario> getListaAlunosTurma() {
		if(listaAlunosTurma == null){
			listaAlunosTurma = usuarioRN.listaAlunosTurma();
		}
		return listaAlunosTurma;
	}*/
	
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

	public void carregarUsuario(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		usuario = usuarioRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
				
		Long idExcluir = Long.parseLong(id);
		Usuario usuario = usuarioRN.buscarPorId(idExcluir);		
		UploadUtil.removerArquivo(usuario.getFotoPerfil());
		
		usuarioRN.excluir(idExcluir);
		listaUsuarios = null;
		return "/admin/listaUsuario";
	}
	
	public String salvar(){
		try{
			String nomeFotoPerfil = UploadUtil.moverArquivo(uploadedFotoPerfil, usuario.getFotoPerfil());
			
			usuario.setFotoPerfil(nomeFotoPerfil);							
			usuarioRN.salvar(usuario);
			listaUsuarios = null;
			return "/admin/listaUsuario";
			
		} catch(IOException e){
			e.printStackTrace();
			return "";
		}
				
	}
	
	public String alunosCadastrados(){
		if(listaAlunosCadastrados == null){
			if(usuario.getPerfil().equals(Perfil.Professor)){
				listaAlunosCadastrados = usuarioRN.listarProfessores();
				tamanho = listaAlunosCadastrados.size();
			}else if(usuario.getPerfil().equals(Perfil.Aluno)){
				listaAlunosCadastrados = usuarioRN.listarAlunos();
				tamanho = listaAlunosCadastrados.size();
			}else if(usuario.getPerfil().equals(Perfil.Administrador)){
				listaAlunosCadastrados = usuarioRN.listarAdministradores();
				tamanho = listaAlunosCadastrados.size();
			}
		}
		return "/admin/relatorioAlunosCadastrados";
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

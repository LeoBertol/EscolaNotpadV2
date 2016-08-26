package br.escolanotpad.sc.mb;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.escolanotpad.sc.model.entity.Perfil;
import br.escolanotpad.sc.model.entity.Usuario;
import br.escolanotpad.sc.model.UsuarioRN;

@SessionScoped
@ManagedBean
public class SessaoMB {
	
	private String emailForm;
	private String senhaForm;
	private Usuario usuarioLogado;
	private String redirecionamento;
	
	public String getEmailForm() {
		return emailForm;
	}
	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}
	public String getSenhaForm() {
		return senhaForm;
	}
	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean estaLogado(){
		return usuarioLogado != null;
	}
	
	public boolean ehAdmin(){
		return usuarioLogado != null && usuarioLogado.getPerfil().equals(Perfil.Administrador);
	}
	
	public boolean ehAluno(){
		return usuarioLogado != null && usuarioLogado.getPerfil().equals(Perfil.Aluno);
	}
	
	public boolean ehProfessor(){
		return usuarioLogado != null && usuarioLogado.getPerfil().equals(Perfil.Professor);
	}
	
	public String getNomeUsuarioLogado(){
		return usuarioLogado == null ? "" : usuarioLogado.getNome();
	}
	
	public String getEmailUsuarioLogado(){
		return usuarioLogado == null ? "" : usuarioLogado.getEmail();
	}
	
	public Long getIdUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getId();
	}
	
	public String getFotoUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getFotoPerfil();
	}
	
	public Date getDataUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getDataNascimento();
	}
	
	public String getCPFUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getCpf();
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/login?faces-redirect=true";
	}
	
	public String entrar() {
		UsuarioRN usuarioRN = new UsuarioRN();
		if (emailForm != null && !emailForm.isEmpty()&& senhaForm != null && !senhaForm.isEmpty()) {
			
			Usuario usuario = usuarioRN.buscarPorEmail(emailForm);

			if (usuario != null && usuario.getEmail().equalsIgnoreCase(emailForm)&& usuario.getSenha().equals(senhaForm)) {
				usuarioLogado = usuario;
				
				if(usuario.getPerfil().equals(Perfil.Administrador)){
					redirecionamento = "/admin/index?faces-redirect=true";
				}else if(usuario.getPerfil().equals(Perfil.Aluno)){
					redirecionamento = "/aluno/index?faces-redirect=true";
				}else if(usuario.getPerfil().equals(Perfil.Professor)){
					redirecionamento = "/prof/index?faces-redirect=true";
				}
				
				return redirecionamento;
			}
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-mail ou senha incorretos"));
		return "";
	}

}
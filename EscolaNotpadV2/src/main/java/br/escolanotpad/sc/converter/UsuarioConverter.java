package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.UsuarioRN;
import br.escolanotpad.sc.model.entity.Usuario;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
		UsuarioRN usuarioRN = new UsuarioRN();
		Long id = Long.parseLong(value);
		return usuarioRN.buscarPorId(id);
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value){
		Usuario usuario = (Usuario) value;
		return usuario.getId().toString();
	}
	
}

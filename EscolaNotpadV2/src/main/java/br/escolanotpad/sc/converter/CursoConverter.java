package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.CursoRN;
import br.escolanotpad.sc.model.entity.Curso;

@FacesConverter(forClass=Curso.class)
public class CursoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
		CursoRN cursoRN = new CursoRN();
		Long id = Long.parseLong(value);
		return cursoRN.buscarPorId(id);
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value){
		Curso curso = (Curso) value;
		return curso.getId().toString();
	}
	
}

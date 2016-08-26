package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.PerguntaRN;
import br.escolanotpad.sc.model.entity.Pergunta;

@FacesConverter(forClass=Pergunta.class)
public class PerguntaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
		PerguntaRN perguntaRN = new PerguntaRN();
		Long id = Long.parseLong(value);
		return perguntaRN.buscarPorId(id);
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value){
		Pergunta pergunta = (Pergunta) value;
		return pergunta.getId().toString();
	}
	
}

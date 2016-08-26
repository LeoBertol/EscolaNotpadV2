package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.RespostaRN;
import br.escolanotpad.sc.model.entity.Resposta;

@FacesConverter(forClass=Resposta.class)
public class RespostaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
		RespostaRN respostaRN = new RespostaRN();
		Long id = Long.parseLong(value);
		return respostaRN.buscarPorId(id);
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value){
		Resposta resposta = (Resposta) value;
		return resposta.getId().toString();
	}
	
}

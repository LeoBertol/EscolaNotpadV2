package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.ArquivoRN;
import br.escolanotpad.sc.model.entity.Arquivo;

@FacesConverter(forClass=Arquivo.class)
public class ArquivoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value){
		ArquivoRN arquivoRN = new ArquivoRN();
		Long id = Long.parseLong(value);
		return arquivoRN.buscarPorId(id);
	}
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value){
		Arquivo arquivo = (Arquivo) value;
		return arquivo.getId().toString();
	}
	
}

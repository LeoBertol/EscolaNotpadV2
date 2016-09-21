package br.escolanotpad.sc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.escolanotpad.sc.model.RegraRN;
import br.escolanotpad.sc.model.entity.Regra;

@FacesConverter(forClass=Regra.class, value="regraConverter")
public class RegraConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		long id = Long.parseLong(value);
		RegraRN regraRN = new RegraRN();
		return regraRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Regra regra = (Regra) value;
		return String.valueOf(regra.getId());
	}

}

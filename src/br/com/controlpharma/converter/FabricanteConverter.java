package br.com.controlpharma.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.domain.Fabricante;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {

		try {
			Long codigo = Long.parseLong(valor);

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			Fabricante fabricante = fabricanteDAO.buscarPorCodigo(codigo);

			return fabricante;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
		try {
			Fabricante fabricante = (Fabricante) objeto;
			Long codigo = fabricante.getIdFabricante();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
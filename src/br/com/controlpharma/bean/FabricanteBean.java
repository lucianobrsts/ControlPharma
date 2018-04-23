package br.com.controlpharma.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.domain.Fabricante;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricanteCadastro;

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null) {
			fabricanteCadastro = new Fabricante();
		}
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public void novo() {
		fabricanteCadastro = new Fabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabDAO.salvar(fabricanteCadastro);

			fabricanteCadastro = new Fabricante();

			FacesUtil.adicionarMensagemInfo("Fabricante salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir um fabricante: " + ex.getMessage());
		}

	}
}

package br.com.controlpharma.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.domain.Fabricante;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricanteCadastro;

	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabrcantesFiltrados;

	private String acao;
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabrcantesFiltrados() {
		return listaFabrcantesFiltrados;
	}

	public void setListaFabrcantesFiltrados(List<Fabricante> listaFabrcantesFiltrados) {
		this.listaFabrcantesFiltrados = listaFabrcantesFiltrados;
	}

	public Fabricante getFabricanteCadastro() {
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

	public void carregarPesquisa() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			listaFabricantes = fabDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os fabricantes: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				FabricanteDAO fabDAO = new FabricanteDAO();
				fabricanteCadastro = fabDAO.buscarPorCodigo(codigo);
			} else {
				fabricanteCadastro = new Fabricante();
			}
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do fabricante: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();
			fabDAO.excluir(fabricanteCadastro);

			FacesUtil.adicionarMensagemInfo("Fabricante excluído com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o fabricante: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			FabricanteDAO fabDAO = new FabricanteDAO();

			fabDAO.editar(fabricanteCadastro);

			FacesUtil.adicionarMensagemInfo("Fabricante editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o fabricante: " + ex.getMessage());
		}
	}
}

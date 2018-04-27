package br.com.controlpharma.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.domain.Produto;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produtoCadastro;

	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;

	private String acao;
	private Long codigo;

	public Produto getProdutoCadastro() {
		return produtoCadastro;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void novo() {
		produtoCadastro = new Produto();
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produtoCadastro);

			produtoCadastro = new Produto();

			FacesUtil.adicionarMensagemInfo("Produto salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir um produto: " + ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os produtos: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoCadastro = produtoDAO.buscarPorCodigo(codigo);
			} else {
				produtoCadastro = new Produto();
			}
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do produto: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produtoCadastro);

			FacesUtil.adicionarMensagemInfo("Produto excluído com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o Produto: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.editar(produtoCadastro);

			FacesUtil.adicionarMensagemInfo("Produto editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o produto: " + ex.getMessage());
		}
	}
}

package br.com.controlpharma.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.dao.FuncionarioDAO;
import br.com.controlpharma.dao.ItemDAO;
import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.dao.VendaDAO;
import br.com.controlpharma.domain.Funcionario;
import br.com.controlpharma.domain.Item;
import br.com.controlpharma.domain.Produto;
import br.com.controlpharma.domain.Venda;
import br.com.controlpharma.filter.VendaFilter;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;

	private Venda vendaCadastro;
	private List<Item> listaItens;

	@ManagedProperty(value = "#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;

	private VendaFilter filtro;
	private List<Venda> listaVendas;

	public List<Venda> getListaVendas() {
		return listaVendas;
	}

	public void setListaVendas(List<Venda> listaVendas) {
		this.listaVendas = listaVendas;
	}

	public VendaFilter getFiltro() {
		if (filtro == null) {
			filtro = new VendaFilter();
		}
		return filtro;
	}

	public void setFiltro(VendaFilter filtro) {
		this.filtro = filtro;
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

	public List<Item> getListaItens() {
		if (listaItens == null) {
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}

	public void setListaItem(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public Venda getVendaCadastro() {
		if (vendaCadastro == null) {
			vendaCadastro = new Venda();
			vendaCadastro.setHorario(new Date());
			vendaCadastro.setValorTotal(new BigDecimal("0.00"));
			vendaCadastro.setQuantidadeTotal(0);
		}
		return vendaCadastro;
	}

	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	public void carregarProdutos() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os produtos: " + ex.getMessage());
		}
	}

	public void adicionar(Produto produto) {
		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {
			Item ItemTemp = listaItens.get(pos);

			if (ItemTemp.getProduto().equals(produto)) {
				posicaoEncontrada = pos;
			}
		}

		Item item = new Item();
		item.setProduto(produto);

		if (posicaoEncontrada < 0) {
			item.setQuantidade(1);
			item.setValorParcial(produto.getPreco());
			listaItens.add(item);
		} else {
			Item itemTemp = listaItens.get(posicaoEncontrada);
			item.setQuantidade(itemTemp.getQuantidade() + 1);
			item.setValorParcial(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			listaItens.set(posicaoEncontrada, item);
		}

		vendaCadastro.setValorTotal(vendaCadastro.getValorTotal().add(produto.getPreco()));

		vendaCadastro.setQuantidadeTotal(vendaCadastro.getQuantidadeTotal() + 1);

	}

	public void remover(Item item) {
		int posicaoEncontrada = -1;

		for (int pos = 0; pos < listaItens.size() && posicaoEncontrada < 0; pos++) {
			Item ItemTemp = listaItens.get(pos);

			if (ItemTemp.getProduto().equals(item.getProduto())) {
				posicaoEncontrada = pos;
			}
		}

		if (posicaoEncontrada > -1) {
			listaItens.remove(posicaoEncontrada);
			vendaCadastro.setValorTotal(vendaCadastro.getValorTotal().subtract(item.getValorParcial()));

			vendaCadastro.setQuantidadeTotal(vendaCadastro.getQuantidadeTotal() - item.getQuantidade());
		}
	}

	public void carregarDadosVenda() {
		vendaCadastro.setHorario(new Date());

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Funcionario funcionario = funcionarioDAO
				.buscarPorCodigo(autenticacaoBean.getFuncionarioLogado().getIdFuncionario());

		vendaCadastro.setFuncionario(funcionario);
	}

	public void salvar() {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			Long codigoVenda = vendaDAO.salvar(vendaCadastro);
			Venda vendaFK = vendaDAO.buscarPorCodigo(codigoVenda);

			for (Item item : listaItens) {
				item.setVenda(vendaFK);

				ItemDAO itemDAO = new ItemDAO();
				itemDAO.salvar(item);
			}

			vendaCadastro = new Venda();
			vendaCadastro.setValorTotal(new BigDecimal("0.00"));

			listaItens = new ArrayList<Item>();

			FacesUtil.adicionarMensagemInfo("Venda salva com sucesso.");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar a venda.");
		}
	}

	public void buscar() {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			listaVendas = vendaDAO.buscar(filtro);

			for (Venda venda : listaVendas) {
				System.out.println(venda);
			}
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar buscar uma venda: " + ex.getMessage());
		}
	}

}

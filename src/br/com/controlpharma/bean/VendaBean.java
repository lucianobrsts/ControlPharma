package br.com.controlpharma.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.domain.Item;
import br.com.controlpharma.domain.Produto;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;

	private List<Item> listaItens;

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

	}

}

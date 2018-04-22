package br.com.controlpharma.Test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.ItemDAO;
import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.dao.VendaDAO;
import br.com.controlpharma.domain.Item;
import br.com.controlpharma.domain.Produto;
import br.com.controlpharma.domain.Venda;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {
		VendaDAO vendadao = new VendaDAO();
		Venda venda = vendadao.buscarPorCodigo(3L);

		ProdutoDAO prodao = new ProdutoDAO();
		Produto produto = prodao.buscarPorCodigo(2L);

		Item item = new Item();
		item.setQuantidade(2);
		item.setValorParcial(new BigDecimal(15.59D));
		item.setProduto(produto);
		item.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();

		List<Venda> vendas = vendaDAO.listar();

		System.out.println(vendas);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(5L);

		System.out.println(venda);
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(2L);

		vendaDAO.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = vendaDAO.buscarPorCodigo(3L);

		venda.setValorTotal(new BigDecimal(18.30D));

		vendaDAO.editar(venda);
	}

}

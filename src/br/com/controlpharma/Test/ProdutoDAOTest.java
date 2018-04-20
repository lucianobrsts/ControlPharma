package br.com.controlpharma.Test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.domain.Fabricante;
import br.com.controlpharma.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscarPorCodigo(1L);

		Produto produto = new Produto();
		produto.setDescricao("Descricao J");
		produto.setPreco(new BigDecimal(23.55D));
		produto.setQuantidade(17);
		produto.setFabricante(fabricante);

		ProdutoDAO pdao = new ProdutoDAO();
		pdao.salvar(produto);
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();

		System.out.println(produtos);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarPorCodigo(5L);

		System.out.println(produto);
	}

	@Test
	@Ignore
	public void escluir() {
		ProdutoDAO dao = new ProdutoDAO();

		Produto produto = dao.buscarPorCodigo(1L);

		dao.excluir(produto);
	}

}

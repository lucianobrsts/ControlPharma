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
		Fabricante fabricante = fdao.buscarPorCodigo(2L);

		Produto produto = new Produto();
		produto.setDescricao("Descricao H");
		produto.setPreco(new BigDecimal(10.55D));
		produto.setQuantidade(9);
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

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarPorCodigo(2L);

		produto.setDescricao("Aspirina");
		produto.setPreco(new BigDecimal(1.29D));
		produto.setQuantidade(13);
		
		
		FabricanteDAO fabdao = new FabricanteDAO();
		Fabricante fab = fabdao.buscarPorCodigo(2L);
		produto.setFabricante(fab);

		dao.editar(produto);
	}

}

package br.com.controlpharma.Test;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.dao.ProdutoDAO;
import br.com.controlpharma.domain.Fabricante;
import br.com.controlpharma.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() {
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscarPorCodigo(20L);

		Produto produto = new Produto();
		produto.setDescricao("Descricao J");
		produto.setPreco(new BigDecimal(23.55D));
		produto.setQuantidade(17);
		produto.setFabricante(fabricante);

		ProdutoDAO pdao = new ProdutoDAO();
		pdao.salvar(produto);
	}

}

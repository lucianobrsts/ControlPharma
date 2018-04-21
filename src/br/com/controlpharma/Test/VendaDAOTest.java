package br.com.controlpharma.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.FuncionarioDAO;
import br.com.controlpharma.dao.VendaDAO;
import br.com.controlpharma.domain.Funcionario;
import br.com.controlpharma.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO fundao = new FuncionarioDAO();
		Funcionario funcionario = fundao.buscarPorCodigo(1L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal(78.34D));

		VendaDAO vendadao = new VendaDAO();
		vendadao.salvar(venda);
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

}

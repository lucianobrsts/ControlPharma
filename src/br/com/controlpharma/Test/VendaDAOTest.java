package br.com.controlpharma.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.FuncionarioDAO;
import br.com.controlpharma.dao.VendaDAO;
import br.com.controlpharma.domain.Funcionario;
import br.com.controlpharma.domain.Venda;
import br.com.controlpharma.filter.VendaFilter;

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

	@Test
	@Ignore
	public void buscar() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		VendaFilter filtro = new VendaFilter();
		filtro.setDataInicial(formato.parse("21/04/2018"));
		filtro.setDataFinal(formato.parse("31/04/2018"));

		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> vendas = vendaDAO.buscar(filtro);

		for (Venda venda : vendas) {
			System.out.println(venda);
		}
	}

}

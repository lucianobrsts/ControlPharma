package br.com.controlpharma.Test;

import java.math.BigDecimal;
import java.util.Date;

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

}

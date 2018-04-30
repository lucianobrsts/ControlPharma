package br.com.controlpharma.Test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.FuncionarioDAO;
import br.com.controlpharma.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Funcionario func = new Funcionario();
		func.setCpf("222.222.222-22");
		func.setFuncao("Ator");
		func.setNome("Lucas Almeida");
		func.setSenha("122");

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(func);
	}

	@Test
	@Ignore
	public void listar() {

		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario func1 = dao.buscarPorCodigo(1L);

		System.out.println(func1);
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario func = dao.buscarPorCodigo(3L);

		dao.excluir(func);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = dao.buscarPorCodigo(1L);

		func.setCpf("111.111.111-11");
		func.setFuncao("Professor");
		func.setNome("Otavio Mesquita");
		func.setSenha("111");

		dao.editar(func);
	}

	@Test
	@Ignore
	public void autenticar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Funcionario funcionario = funcionarioDAO.autenticar("522.704.520-89", "123456");

		Assert.assertNotNull(funcionario);
	}

}

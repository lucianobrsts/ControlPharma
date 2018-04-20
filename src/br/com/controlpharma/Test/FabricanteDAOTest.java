package br.com.controlpharma.Test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("DescriçãoD");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(1L);
		Fabricante fabricante2 = dao.buscarPorCodigo(13L);

		System.out.println(fabricante);
		System.out.println(fabricante2);
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(15L);

		dao.excluir(fabricante);

	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fabricante = dao.buscarPorCodigo(11L);

		fabricante.setDescricao("DescriçãoY");

		dao.editar(fabricante);

	}

}

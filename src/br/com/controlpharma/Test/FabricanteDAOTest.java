package br.com.controlpharma.Test;

import org.junit.Test;

import br.com.controlpharma.dao.FabricanteDAO;
import br.com.controlpharma.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Descri��oA");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("Descri��oB");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}

}

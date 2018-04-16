package br.com.controlpharma.Test;

import org.junit.Test;

import br.com.controlpharma.util.HibernateUtil;

public class GerarTabelasTest {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}

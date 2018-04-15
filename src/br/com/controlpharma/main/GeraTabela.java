package br.com.controlpharma.main;

import br.com.controlpharma.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		
		HibernateUtil.getSessionFactory().close();
	}

}

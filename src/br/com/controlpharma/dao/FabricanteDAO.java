package br.com.controlpharma.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.controlpharma.domain.Fabricante;
import br.com.controlpharma.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
}

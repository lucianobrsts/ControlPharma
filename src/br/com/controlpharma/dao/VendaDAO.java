package br.com.controlpharma.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.controlpharma.domain.Venda;
import br.com.controlpharma.util.HibernateUtil;

public class VendaDAO {

	public void salvar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(venda);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

}

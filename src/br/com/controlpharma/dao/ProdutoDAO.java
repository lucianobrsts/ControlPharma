package br.com.controlpharma.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.controlpharma.domain.Produto;
import br.com.controlpharma.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(produto);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

}

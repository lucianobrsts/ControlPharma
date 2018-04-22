package br.com.controlpharma.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.controlpharma.domain.Item;
import br.com.controlpharma.util.HibernateUtil;

public class ItemDAO {
	public void salvar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(item);
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

	@SuppressWarnings("unchecked")
	public List<Item> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Item> itens = null;

		try {
			Query consulta = sessao.getNamedQuery("Item.listar");
			itens = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return itens;
	}

	public Item buscarPorCodigo(Long idItem) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Item item = null;

		try {
			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("idItem", idItem);

			item = (Item) consulta.uniqueResult();
		} catch (Exception ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return item;
	}

	public void excluir(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(item);
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

	public void editar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(item);
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

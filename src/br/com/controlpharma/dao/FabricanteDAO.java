package br.com.controlpharma.dao;

import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public List<Fabricante> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;

		try {
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return fabricantes;
	}

	public Fabricante buscarPorCodigo(Long idFabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;

		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("idFabricante", idFabricante);

			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return fabricante;
	}

	public void excluir(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void excluir(Long idFabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Fabricante fabricante = buscarPorCodigo(idFabricante);
			sessao.delete(fabricante);
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

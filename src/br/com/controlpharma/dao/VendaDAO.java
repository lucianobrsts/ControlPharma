package br.com.controlpharma.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.controlpharma.domain.Venda;
import br.com.controlpharma.filter.VendaFilter;
import br.com.controlpharma.util.HibernateUtil;

public class VendaDAO {

	public Long salvar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		Long codigo = null;

		try {
			transacao = sessao.beginTransaction();
			codigo = (Long) sessao.save(venda);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
		return codigo;
	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> vendas = null;

		try {
			Query consulta = sessao.getNamedQuery("Venda.listar");
			vendas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return vendas;
	}

	public Venda buscarPorCodigo(Long idVenda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;

		try {
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("idVenda", idVenda);

			venda = (Venda) consulta.uniqueResult();
		} catch (Exception ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return venda;
	}

	public void excluir(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(venda);
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

	public void editar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(venda);
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
	public List<Venda> buscar(VendaFilter filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> vendas = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT venda FROM Venda venda ");

		if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
			sql.append("WHERE venda.horario BETWEEN :dataInicial AND :dataFinal ");
		}

		sql.append("ORDER BY venda.horario ");

		try {
			Query consulta = sessao.createQuery(sql.toString());
			if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
				consulta.setDate("dataInicial", filtro.getDataInicial());
				consulta.setDate("dataFinal", filtro.getDataFinal());
			}

			vendas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return vendas;
	}

}

package br.com.controlpharma.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@NamedQueries({ @NamedQuery(name = "Item.listar", query = "SELECT item FROM Item item"),
		@NamedQuery(name = "Item.buscarPorCodigo", query = "SELECT item FROM Item item WHERE item.idItem = :idItem") })
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idItem")
	private Long idItem;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valorParcial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "venda_idVenda", referencedColumnName = "idVenda", nullable = false)
	private Venda venda;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_idProduto", referencedColumnName = "idProduto", nullable = false)
	private Produto produto;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [idItens=" + idItem + ", quantidade=" + quantidade + ", valorParcial=" + valorParcial + ", venda="
				+ venda + ", produto=" + produto + "]";
	}

}

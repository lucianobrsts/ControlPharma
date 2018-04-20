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
@Table(name = "produto")
@NamedQueries({ @NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
		@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE idProduto = :idProduto") })
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProduto")
	private Long idProduto;

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_idFabricante", referencedColumnName = "idFabricante")
	private Fabricante fabricante;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
				+ quantidade + ", fabricante=" + fabricante + "]";
	}

}

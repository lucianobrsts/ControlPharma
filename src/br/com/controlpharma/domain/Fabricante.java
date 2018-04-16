package br.com.controlpharma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
@NamedQueries({ @NamedQuery(name = "Fabricante.listar", query = "SELECT fabricante FROM Fabricante fabricante") })
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFabricante")
	private Long idFabricante;

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", descricao=" + descricao + "]";
	}

}

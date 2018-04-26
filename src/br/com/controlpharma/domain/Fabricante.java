package br.com.controlpharma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "fabricante")
@NamedQueries({ @NamedQuery(name = "Fabricante.listar", query = "SELECT fabricante FROM Fabricante fabricante"),
		@NamedQuery(name = "Fabricante.buscarPorCodigo", query = "SELECT fabricante FROM Fabricante fabricante WHERE fabricante.idFabricante = :idFabricante") })
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFabricante")
	private Long idFabricante;

	@NotEmpty(message = "O campo descrição é obrigatório!")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo descrição (5 - 50)")
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

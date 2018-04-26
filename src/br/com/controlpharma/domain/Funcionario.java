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
import org.hibernate.validator.constraints.br.CPF;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "funcionario")
@NamedQueries({ @NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
		@NamedQuery(name = "Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.idFuncionario = :idFuncionario") })
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFuncionario")
	private Long idFuncionario;

	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo Nome (5 - 10)")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@CPF(message="O CPF informado é inválido.")
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@NotEmpty(message = "O campo Senha é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo Senha (6 - 8)")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

	@NotEmpty(message = "O campo Função é obrigatório.")
	@Column(name = "funcao", length = 50, nullable = false)
	private String funcao;

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", funcao=" + funcao + "]";
	}

}

package br.com.controlpharma.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.controlpharma.dao.FuncionarioDAO;
import br.com.controlpharma.domain.Funcionario;
import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Funcionario funcionarioLogado;

	public Funcionario getFuncionarioLogado() {
		if (funcionarioLogado == null) {
			funcionarioLogado = new Funcionario();
		}
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public void autenticar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

			funcionarioLogado = funcionarioDAO.autenticar(funcionarioLogado.getCpf(),
					DigestUtils.md5Hex(funcionarioLogado.getSenha()));

			if (funcionarioLogado == null) {
				FacesUtil.adiconarMensagemErro("CPF ou senha inválido");
			} else {
				FacesUtil.adicionarMensagemInfo("Funcionário autenticado com sucesso.");
			}

		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar autenticar no sistema.");
		}
	}

	public String sair() {
		funcionarioLogado = null;

		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

}

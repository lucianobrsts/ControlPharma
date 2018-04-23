package br.com.controlpharma.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlpharma.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	public void salvar() {
		FacesUtil.adicionarMensagemInfo("Funcionário salvo com sucesso!");
	}
}

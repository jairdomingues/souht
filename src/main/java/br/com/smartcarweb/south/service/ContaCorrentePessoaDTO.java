package br.com.smartcarweb.south.service;

import java.io.Serializable;

public class ContaCorrentePessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaDTO pessoa;
	private Long idAgencia;

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

}

package br.com.smartcarweb.south.service;

import java.io.Serializable;

import br.com.smartcarweb.south.model.Pessoa;
import br.com.smartcarweb.south.model.PessoaFisica;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apelido;
	private String documento;
	private Short score;

	public static Pessoa createEntity(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		if (pessoaDTO.getDocumento().length() < 12) {
			PessoaFisica pessoaFisica = new PessoaFisica();
			pessoaFisica.setApelido(pessoaDTO.getApelido());
			pessoaFisica.setDocumento(pessoaDTO.getDocumento());
			pessoaFisica.setScore(pessoaDTO.getScore());
			pessoa = pessoaFisica;
		} else {
		}
		return pessoa;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Short getScore() {
		return score;
	}

	public void setScore(Short score) {
		this.score = score;
	}

}

package br.com.smartcarweb.south.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa_fisica")
@NamedQueries({
		@javax.persistence.NamedQuery(name = "PessoaFisica.consultarPorCpf", query = "SELECT pf FROM PessoaFisica pf WHERE pf.documento = :cpf"), })
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Size(max = 11, min = 11, message = "CPF inválido.")
	@Column(name = "cpf", length = 11, nullable = false)
	private String documento;

	@Column(name = "score", nullable = false)
	private Short score;

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

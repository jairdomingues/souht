package br.com.smartcarweb.south.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa_juridica")
@NamedQueries({
		@javax.persistence.NamedQuery(name = "PessoaJuridica.consultarPorCnpj", query = "SELECT pj FROM PessoaJuridica pj WHERE pj.documento = :cnpj"), })
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Size(max = 14, min = 14, message = "CNPJ inválido.")
	@Column(name = "cnpj", length = 14, nullable = false)
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

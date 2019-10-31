package br.com.smartcarweb.south.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseEntity;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "apelido", nullable = false)
	private String apelido;

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}

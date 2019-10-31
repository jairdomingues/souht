package br.com.smartcarweb.south.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseEntity;

@Entity
@Table(name = "cheque_especial")
public class ChequeEspecial extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "limite", nullable = false)
	private BigDecimal limite;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

}
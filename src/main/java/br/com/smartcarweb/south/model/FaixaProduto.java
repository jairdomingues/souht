package br.com.smartcarweb.south.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseEntity;

@Entity
@Table(name = "faixa_produto")
public class FaixaProduto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;
	private Short de;
	private Short ate;
	private BigDecimal limiteChequeEspecial;
	private BigDecimal limiteCartaoCredito;

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

	public Short getDe() {
		return de;
	}

	public void setDe(Short de) {
		this.de = de;
	}

	public Short getAte() {
		return ate;
	}

	public void setAte(Short ate) {
		this.ate = ate;
	}

	public BigDecimal getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public BigDecimal getLimiteCartaoCredito() {
		return limiteCartaoCredito;
	}

	public void setLimiteCartaoCredito(BigDecimal limiteCartaoCredito) {
		this.limiteCartaoCredito = limiteCartaoCredito;
	}

}
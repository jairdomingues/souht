package br.com.smartcarweb.south.service;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.smartcarweb.south.model.Agencia;
import br.com.smartcarweb.south.model.CartaoCredito;
import br.com.smartcarweb.south.model.ChequeEspecial;
import br.com.smartcarweb.south.model.ContaCorrente.TipoDeConta;

public class ContaCorrenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoDeConta tipoDeConta;
	private String numero;
	private Agencia agencia;
	private PessoaDTO pessoa;
	private CartaoCredito cartaoCredito;
	private ChequeEspecial chequeEspecial;
	public BigDecimal saldo;

	public TipoDeConta getTipoDeConta() {
		return tipoDeConta;
	}

	public void setTipoDeConta(TipoDeConta tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public ChequeEspecial getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(ChequeEspecial chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}

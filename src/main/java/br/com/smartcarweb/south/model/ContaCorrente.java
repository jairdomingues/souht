package br.com.smartcarweb.south.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseEntity;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public static enum TipoDeConta {
		Corrente("Corrente"), Empresarial("Empresarial");

		private final String value;

		private TipoDeConta(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipodeconta", nullable = false)
	private TipoDeConta tipoDeConta;

	@Column(name = "numero", nullable = false)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "idagencia", nullable = false)
	private Agencia agencia;

	@ManyToOne
	@JoinColumn(name = "idpessoa", nullable = false)
	private Pessoa pessoa;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcontacorrente")
	private List<MovimentoFinanceiro> movimentos;

	@OneToOne(cascade = CascadeType.ALL)
	private CartaoCredito cartaoCredito;

	@OneToOne(cascade = CascadeType.ALL)
	private ChequeEspecial chequeEspecial;

	@Transient
	public BigDecimal getSaldo() {

		BigDecimal valorDebito = new BigDecimal(0);
		BigDecimal valorCredito = new BigDecimal(0);
		if (this.movimentos != null && !this.movimentos.isEmpty()) {
			List<MovimentoFinanceiro> listaDebito = this.movimentos.stream()
					.filter(x -> x.getTipoDeMovimento().equals(MovimentoFinanceiro.TipoDeMovimento.Debito)
							&& x.getStatus().equals(MovimentoFinanceiro.Status.Ativo))
					.collect(Collectors.toList());
			if (listaDebito.size() > 0) {
				valorDebito = listaDebito.stream().map((e) -> e.getValor()).reduce((sum, e) -> sum.add(e)).get();
			}
			List<MovimentoFinanceiro> listaCredito = this.movimentos.stream()
					.filter(x -> x.getTipoDeMovimento().equals(MovimentoFinanceiro.TipoDeMovimento.Credito)
							&& x.getStatus().equals(MovimentoFinanceiro.Status.Ativo))
					.collect(Collectors.toList());
			if (listaCredito.size() > 0) {
				valorCredito = listaCredito.stream().map((e) -> e.getValor()).reduce((sum, e) -> sum.add(e)).get();
			}
		}
		return valorCredito.subtract(valorDebito);
	}

	@Transient
	public Boolean isChequeEspecial() {
		return this.chequeEspecial != null ? true : false;
	}

	@Transient
	public Boolean isCartaoCredito() {
		return this.cartaoCredito != null ? true : false;
	}

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<MovimentoFinanceiro> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<MovimentoFinanceiro> movimentos) {
		this.movimentos = movimentos;
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

}
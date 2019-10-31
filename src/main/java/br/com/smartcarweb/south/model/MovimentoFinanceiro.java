package br.com.smartcarweb.south.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseEntity;

@Entity
@Table(name = "movimento_financeiro")
public class MovimentoFinanceiro extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public static enum TipoDeMovimento {
		Debito("Debito"), Credito("Credito");

		private final String value;

		private TipoDeMovimento(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum Status {
		Ativo("Ativo"), Anterior("Anterior"), Estorno("Estorno");

		private final String value;

		private Status(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum Situacao {
		Venda("Venda"), Bloqueado("Bloqueado"), Pagamento("Pagamento");

		private final String value;

		private Situacao(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipodemovimento", nullable = false)
	private TipoDeMovimento tipoDeMovimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable = false)
	private Situacao situacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	@Column(name = "historico", nullable = false)
	private String historico;

	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@Column(name = "dataLancamento", nullable = false)
	private Date dataLancamento;

	public TipoDeMovimento getTipoDeMovimento() {
		return tipoDeMovimento;
	}

	public void setTipoDeMovimento(TipoDeMovimento tipoDeMovimento) {
		this.tipoDeMovimento = tipoDeMovimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
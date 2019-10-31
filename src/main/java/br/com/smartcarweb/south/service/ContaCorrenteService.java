package br.com.smartcarweb.south.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.smartcarweb.api.apoio.util.ConversorClasse;
import br.com.smartcarweb.api.apoio.util.Util;
import br.com.smartcarweb.south.dao.AgenciaDAO;
import br.com.smartcarweb.south.dao.CartaoCreditoDAO;
import br.com.smartcarweb.south.dao.ChequeEspecialDAO;
import br.com.smartcarweb.south.dao.ContaCorrenteDAO;
import br.com.smartcarweb.south.dao.FaixaProdutoDAO;
import br.com.smartcarweb.south.dao.PessoaFisicaDAO;
import br.com.smartcarweb.south.model.Agencia;
import br.com.smartcarweb.south.model.CartaoCredito;
import br.com.smartcarweb.south.model.ChequeEspecial;
import br.com.smartcarweb.south.model.ContaCorrente;
import br.com.smartcarweb.south.model.ContaCorrente.TipoDeConta;
import br.com.smartcarweb.south.model.FaixaProduto;
import br.com.smartcarweb.south.model.Pessoa;
import br.com.smartcarweb.south.model.PessoaFisica;
import br.com.smartcarweb.south.model.PessoaJuridica;

@Stateless
public class ContaCorrenteService {

	@Inject
	PessoaService pessoaService;

	@Inject
	ContaCorrenteDAO contaCorrenteDAO;

	@Inject
	CartaoCreditoDAO cartaoCreditoDAO;
	
	@Inject
	ChequeEspecialDAO chequeEspecialDAO;

	@Inject
	AgenciaDAO agenciaDAO;
	
	@Inject
	FaixaProdutoDAO faixaProdutoDAO;

	@Inject
	PessoaFisicaDAO pessoaFisicaDAO;
	
	public void criarPessoaContaCorrente(ContaCorrentePessoaDTO contaCorrenteDTO) {
		Pessoa pessoa = pessoaService.criarPessoa(contaCorrenteDTO.getPessoa());
		this.criarContaCorrente(contaCorrenteDTO.getIdAgencia(), contaCorrenteDTO.getPessoa().getScore(), pessoa);
	}
	
	public void criarProdutoContaCorrente(Long idContaCorrente) {
		ContaCorrente contaCorrente = contaCorrenteDAO.consultarPorId(idContaCorrente);
		Short score = null;
		if ( contaCorrente.getPessoa() instanceof PessoaFisica) {
			PessoaFisica pessoaFisica = (PessoaFisica) contaCorrente.getPessoa(); 
			score = pessoaFisica.getScore();
		} else {
			PessoaJuridica pessoaJuridica = (PessoaJuridica) contaCorrente.getPessoa(); 
			score = pessoaJuridica.getScore();
		}
		List<FaixaProduto> faixas = faixaProdutoDAO.listarTodos();
		for (FaixaProduto faixa : faixas) {
			if(score>=faixa.getDe() && score<=faixa.getAte()) {
				criarProdutoCartaoCredito(contaCorrente, faixa);
				criarProdutoChequeEspecial(contaCorrente, faixa);
			} else {
				continue;
			}
		}
	}

	private void criarContaCorrente(Long idAgencia, Short score, Pessoa pessoa) {
		Agencia agencia = agenciaDAO.consultarPorId(idAgencia);
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setAgencia(agencia);
		if ( pessoa instanceof PessoaFisica) {
			contaCorrente.setTipoDeConta(TipoDeConta.Corrente);
		} else {
			contaCorrente.setTipoDeConta(TipoDeConta.Empresarial);
		}
		contaCorrente.setPessoa(pessoa);
		contaCorrente.setNumero(Util.generateRandomProductActivationCode());
		contaCorrenteDAO.inserir(contaCorrente);
	}

	private void criarProdutoCartaoCredito(ContaCorrente contaCorrente, FaixaProduto faixaProduto) {
		//se o limite de cartao de credito desta faixa estiver 0 entao nao cria o produto
		if (faixaProduto.getLimiteCartaoCredito().compareTo(BigDecimal.ZERO)==1) {
			CartaoCredito cartaoCredito = new CartaoCredito();
			cartaoCredito.setLimite(faixaProduto.getLimiteCartaoCredito());
			cartaoCredito.setDescricao(faixaProduto.getDescricao());
			cartaoCredito.setNome(faixaProduto.getNome());
			contaCorrente.setCartaoCredito(cartaoCredito);
			contaCorrenteDAO.atualizar(contaCorrente);
		}
	}
	
	private void criarProdutoChequeEspecial(ContaCorrente contaCorrente, FaixaProduto faixaProduto) {
		//se o limite de cheque especial desta faixa estiver 0 entao nao cria o produto
		if (faixaProduto.getLimiteChequeEspecial().compareTo(BigDecimal.ZERO)==1) {
			ChequeEspecial chequeEspecial = new ChequeEspecial();
			chequeEspecial.setLimite(faixaProduto.getLimiteChequeEspecial());
			chequeEspecial.setDescricao(faixaProduto.getDescricao());
			chequeEspecial.setNome(faixaProduto.getNome());
			contaCorrente.setChequeEspecial(chequeEspecial);
			contaCorrenteDAO.atualizar(contaCorrente);
		}
	}
	
	public List<ContaCorrenteDTO> listarContaCorrente() {
		return ConversorClasse.ConverterListaClasses(contaCorrenteDAO.listarTodos(), ContaCorrenteDTO.class, 0);
	}
	

}
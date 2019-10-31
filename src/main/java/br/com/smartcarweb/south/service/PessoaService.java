package br.com.smartcarweb.south.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.smartcarweb.api.apoio.excecoes.ErroAcc;
import br.com.smartcarweb.api.apoio.util.ConversorClasse;
import br.com.smartcarweb.api.apoio.util.Util;
import br.com.smartcarweb.south.dao.PessoaFisicaDAO;
import br.com.smartcarweb.south.dao.PessoaJuridicaDAO;
import br.com.smartcarweb.south.model.Pessoa;
import br.com.smartcarweb.south.model.PessoaFisica;
import br.com.smartcarweb.south.model.PessoaJuridica;

@Stateless
public class PessoaService {

	@Inject
	PessoaFisicaDAO pessoaFisicaDAO;
	
	@Inject
	PessoaJuridicaDAO pessoaJuridicaDAO;
	
	public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = PessoaDTO.createEntity(pessoaDTO);
		if ( pessoa instanceof PessoaFisica) {
			PessoaFisica pessoaFisica = pessoaFisicaDAO.consultarPorCpf(pessoaDTO.getDocumento());
			if (pessoaFisica != null) {
				throw new ErroAcc("CPF já existe.");
			}
			if (!Util.isValidCPF(pessoaDTO.getDocumento())) {
				throw new ErroAcc("CPF inválido.");
			}
			pessoaFisica = (PessoaFisica) pessoa;
			pessoaFisicaDAO.inserir(pessoaFisica);
			return pessoaFisica;
		} else {
			PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.consultarPorCnpj(pessoaDTO.getDocumento());
			if (pessoaJuridica != null) {
				throw new ErroAcc("CNPJ já existe.");
			}
			if (!Util.isValidCNPJ((pessoaDTO.getDocumento()))) {
				throw new ErroAcc("CNPJ inválido.");
			}
			pessoaJuridica = (PessoaJuridica) pessoa;
			pessoaJuridicaDAO.inserir(pessoaJuridica);
			return pessoaJuridica;
		}
	}
	
	public List<PessoaDTO> listarPessoas() {
		List<PessoaDTO> fisicas = ConversorClasse.ConverterListaClasses(pessoaFisicaDAO.listarTodos(), PessoaDTO.class, 0);
		List<PessoaDTO> juridicas = ConversorClasse.ConverterListaClasses(pessoaJuridicaDAO.listarTodos(), PessoaDTO.class,0);
		fisicas.addAll(juridicas);
		return fisicas;
	}
}
package br.com.smartcarweb.south.rest;

import java.util.List;

import javax.inject.Inject;

import br.com.smartcarweb.south.service.PessoaDTO;
import br.com.smartcarweb.south.service.PessoaService;

public class PessoaRestImpl implements PessoaRest {

	@Inject
	PessoaService pessoaService;

	public List<PessoaDTO> listarPessoas() {
		return pessoaService.listarPessoas();
	}
	
}

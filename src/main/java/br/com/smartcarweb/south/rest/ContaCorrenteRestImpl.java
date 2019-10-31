package br.com.smartcarweb.south.rest;

import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.smartcarweb.api.apoio.excecoes.ErroAcc;
import br.com.smartcarweb.api.apoio.excecoes.ErroBase;
import br.com.smartcarweb.api.apoio.util.Util;
import br.com.smartcarweb.south.service.ContaCorrenteDTO;
import br.com.smartcarweb.south.service.ContaCorrentePessoaDTO;
import br.com.smartcarweb.south.service.ContaCorrenteService;

public class ContaCorrenteRestImpl implements ContaCorrenteRest {

	@Inject
	ContaCorrenteService contaCorrenteService;

	public Response criarPessoaContaCorrente(ContaCorrentePessoaDTO contaCorrentePessoaDTO) {
		try {
			contaCorrenteService.criarPessoaContaCorrente(contaCorrentePessoaDTO);
			return Response.status(Response.Status.CREATED).build();
		} catch (ErroBase | ErroAcc erro) {
			throw erro.converterParaRest();
		} catch (EJBTransactionRolledbackException e) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(Util.converterParaRest(e))
		            .type(MediaType.APPLICATION_JSON).build());
		}
	}
	
	public Response criarProdutoContaCorrente(Long idContaCorrente) {
		try {
			contaCorrenteService.criarProdutoContaCorrente(idContaCorrente);
			return Response.status(Response.Status.CREATED).build();
		} catch (ErroBase | ErroAcc erro) {
			throw erro.converterParaRest();
		} catch (EJBTransactionRolledbackException e) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(Util.converterParaRest(e))
		            .type(MediaType.APPLICATION_JSON).build());
		}
	}

	public List<ContaCorrenteDTO> listarContaCorrente() {
		return contaCorrenteService.listarContaCorrente();
	}
	
}

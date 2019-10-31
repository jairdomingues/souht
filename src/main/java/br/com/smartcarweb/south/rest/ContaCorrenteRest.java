package br.com.smartcarweb.south.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.smartcarweb.south.service.ContaCorrenteDTO;
import br.com.smartcarweb.south.service.ContaCorrentePessoaDTO;

@Path(ContaCorrenteRest.PATH)
@Produces(MediaType.APPLICATION_JSON)
public interface ContaCorrenteRest {

	public static final String PATH = "/contas";

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response criarPessoaContaCorrente(ContaCorrentePessoaDTO contaCorrentePessoaDTO);

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response criarProdutoContaCorrente(@PathParam("id") Long idContaCorrente);
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContaCorrenteDTO> listarContaCorrente();


}

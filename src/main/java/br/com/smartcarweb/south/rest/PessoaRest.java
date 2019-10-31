package br.com.smartcarweb.south.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.smartcarweb.south.service.PessoaDTO;

@Path(PessoaRest.PATH)
@Produces(MediaType.APPLICATION_JSON)
public interface PessoaRest {

	public static final String PATH = "/pessoas";

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PessoaDTO> listarPessoas();


}

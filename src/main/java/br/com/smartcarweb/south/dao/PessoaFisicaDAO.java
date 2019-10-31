package br.com.smartcarweb.south.dao;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseDao;
import br.com.smartcarweb.south.model.PessoaFisica;

public interface PessoaFisicaDAO extends BaseDao<PessoaFisica> {

	public abstract PessoaFisica consultarPorCpf(String cpf);
}

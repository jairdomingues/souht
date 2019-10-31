package br.com.smartcarweb.south.dao;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.BaseDao;
import br.com.smartcarweb.south.model.PessoaJuridica;

public interface PessoaJuridicaDAO extends BaseDao<PessoaJuridica> {

	public abstract PessoaJuridica consultarPorCnpj(String cnpj);

}

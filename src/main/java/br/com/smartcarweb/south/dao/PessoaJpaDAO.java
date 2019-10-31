package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.Pessoa;

@Stateless
public class PessoaJpaDAO extends ModeloDao<Pessoa> implements PessoaDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<Pessoa> getDomainClass() {
		return Pessoa.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
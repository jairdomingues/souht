package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.ContaCorrente;

@Stateless
public class ContaCorrenteJpaDAO extends ModeloDao<ContaCorrente> implements ContaCorrenteDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<ContaCorrente> getDomainClass() {
		return ContaCorrente.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
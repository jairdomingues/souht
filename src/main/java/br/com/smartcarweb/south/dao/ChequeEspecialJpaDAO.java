package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.ChequeEspecial;

@Stateless
public class ChequeEspecialJpaDAO extends ModeloDao<ChequeEspecial> implements ChequeEspecialDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<ChequeEspecial> getDomainClass() {
		return ChequeEspecial.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
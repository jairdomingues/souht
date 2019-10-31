package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.CartaoCredito;
import br.com.smartcarweb.south.model.ChequeEspecial;

@Stateless
public class CartaoCreditoJpaDAO extends ModeloDao<CartaoCredito> implements CartaoCreditoDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<CartaoCredito> getDomainClass() {
		return CartaoCredito.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
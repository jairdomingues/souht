package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.PessoaFisica;

@Stateless
public class PessoaFisicaJpaDAO extends ModeloDao<PessoaFisica> implements PessoaFisicaDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<PessoaFisica> getDomainClass() {
		return PessoaFisica.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public PessoaFisica consultarPorCpf(String cpf) {
		PessoaFisica pessoaFisica = null;
		try {
			pessoaFisica = (PessoaFisica) getEntityManager().createNamedQuery("PessoaFisica.consultarPorCpf")
					.setParameter("cpf", cpf).getSingleResult();
		} catch (NoResultException e) {
			pessoaFisica = null;
		}
		return pessoaFisica;
	}

}
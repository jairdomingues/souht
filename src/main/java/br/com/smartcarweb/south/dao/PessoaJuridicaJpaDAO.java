package br.com.smartcarweb.south.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.smartcarweb.api.apoio.util.persistence.ejb3.ModeloDao;
import br.com.smartcarweb.south.model.PessoaJuridica;

@Stateless
public class PessoaJuridicaJpaDAO extends ModeloDao<PessoaJuridica> implements PessoaJuridicaDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "myh2")
	private EntityManager entityManager;

	@Override
	public Class<PessoaJuridica> getDomainClass() {
		return PessoaJuridica.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

    public PessoaJuridica consultarPorCnpj(String cnpj) {
    	PessoaJuridica pessoaJuridica = null;
    	try {
    		pessoaJuridica = (PessoaJuridica) getEntityManager().createNamedQuery("PessoaJuridica.consultarPorCnpj") .setParameter("cnpj",cnpj).getSingleResult();
	    } catch (NoResultException e) {
	    	pessoaJuridica = null;
	    }
    	return pessoaJuridica; 
    }

}
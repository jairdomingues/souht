package br.com.smartcarweb.api.apoio.util.persistence.ejb3;

import br.com.smartcarweb.api.apopio.util.domain.DomainObject;

public interface PersistentObject extends DomainObject {

    Long getId();

    Long getVersao();

    boolean isPersistent();

}

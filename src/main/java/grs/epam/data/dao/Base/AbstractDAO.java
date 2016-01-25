package grs.epam.data.dao.Base;

import grs.epam.data.model.Identified;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public abstract class AbstractDAO<T extends Identified<PK>, PK extends Integer> implements GenericDAO<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}

package grs.epam.data.dao.Base;

import grs.epam.data.model.Identified;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface GenericDAO<T extends Identified<PK>, PK extends Serializable> {

    Class<T> getEntityClass();
    EntityManager getEntityManager();
    String getAllQuery();

    /** Создает новую запись, соответствующую объекту object */
    default void persist(T object) {
        getEntityManager().persist(object);
        getEntityManager().flush();
    }

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    default T readByPK(int id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    /** Удаляет запись об объекте из базы данных */
    default void delete(T object) {
        getEntityManager().remove(object);
    }

    /** Возвращает объект соответствующий записи с критерием или null */
    default List<T> findByQuery(String jpqlQueryString) {
        return findByQueryWithParams(jpqlQueryString, Collections.emptyMap());
    }

    default List<T> findByQueryWithParams(String jpqlQueryString, Map<String, Object> params) {
        TypedQuery<T> query = getEntityManager().createQuery(jpqlQueryString, getEntityClass());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    default List<T> getAll() {
        TypedQuery<T> namedQuery = getEntityManager().createNamedQuery(getAllQuery(), getEntityClass());
        return namedQuery.getResultList();
    }
}

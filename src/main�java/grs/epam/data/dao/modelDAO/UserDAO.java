package grs.epam.data.dao.modelDAO;

import grs.epam.data.dao.Base.GenericDAO;
import grs.epam.data.model.User;

import javax.persistence.TypedQuery;


public interface UserDAO extends GenericDAO<User, Integer> {

    @Override
    default Class<User> getEntityClass() {
        return User.class;
    }

    default User findByUserName(String username){
        TypedQuery<User> query = getEntityManager().createQuery("SELECT u FROM User u WHERE u.login = :username", getEntityClass());
        query.setParameter("username", username);
        return  query.getResultList().get(0);
    }
}

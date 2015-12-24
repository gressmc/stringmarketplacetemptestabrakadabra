package grs.epam.data.dao.modelDAO;

import grs.epam.data.dao.Base.GenericDAO;
import grs.epam.data.model.User;


public interface UserDAO extends GenericDAO<User, Integer> {

    @Override
    default Class<User> getEntityClass() {
        return User.class;
    }
}

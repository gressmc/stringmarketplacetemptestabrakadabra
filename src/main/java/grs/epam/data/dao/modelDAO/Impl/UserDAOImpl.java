package grs.epam.data.dao.modelDAO.Impl;

import grs.epam.data.dao.Base.AbstractDAO;
import grs.epam.data.dao.modelDAO.UserDAO;
import grs.epam.data.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {

    @Override
    public String getAllQuery() {
        return "User.getAll" ;
    }
}

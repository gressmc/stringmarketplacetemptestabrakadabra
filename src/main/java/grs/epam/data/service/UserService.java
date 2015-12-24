package grs.epam.data.service;


import grs.epam.data.dao.modelDAO.UserDAO;
import grs.epam.data.dto.UserDTO;
import grs.epam.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements GenericService<UserDTO> {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public UserDTO create(UserDTO dto) {
        User entity = toEntity(dto);
        userDAO.persist(entity);
        return null;
    }

    @Transactional
    @Override
    public UserDTO update(UserDTO dto) {
        User user = userDAO.readByPK(dto.getId());
        if (user != null) {
            user.setFullName(dto.getFullName());
            user.setLogin(dto.getLogin());
            user.setEmail(dto.getEmail());
            user.setBillingAddress(dto.getBillingAddress());
            user.setPass(dto.getPass());
            userDAO.persist(user);
            return toDTO(user);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO find(Integer id) {
        User user = userDAO.readByPK(id);
        if (user != null) {
            return toDTO(user);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        User user = userDAO.readByPK(id);
        if (user != null) {
            userDAO.delete(user);
        }
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> all = userDAO.getAll();
        return all.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getFullName(), user.getLogin(), user.getPass(), user.getEmail(), user.getBillingAddress());
    }

    private User toEntity(UserDTO dto) {
        User user = User.newBuilder()
                .setUserFullName(dto.getFullName())
                .setUserLogin(dto.getLogin())
                .setUserPass(dto.getPass())
                .setUserEmail(dto.getEmail())
                .setUserAddress(dto.getBillingAddress())
                .build();
        user.setId(dto.getId());
        return user;
    }
}

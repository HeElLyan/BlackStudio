package ru.itis.blackstudio.dao;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Integer id);

    boolean isUnique(String login);

}

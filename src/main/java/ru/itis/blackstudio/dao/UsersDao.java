package ru.itis.blackstudio.dao;

import ru.itis.blackstudio.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersDao extends CrudDao<User> {
    Optional<User> findByUsername(String username);
}

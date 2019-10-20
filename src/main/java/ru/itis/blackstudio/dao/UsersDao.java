package ru.itis.blackstudio.dao;

import ru.itis.blackstudio.models.User;

import java.util.List;

public interface UsersDao extends CrudDao<User> {
    List<User> findAllByUsername(String username);
}

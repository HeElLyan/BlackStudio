package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByUsername(String username);
    void insert(String username, String password, String name, String email, String phone, String birth_date);
}

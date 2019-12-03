package ru.itis.blackstudio.services.imp;

import ru.itis.blackstudio.client.DaoPool;
import ru.itis.blackstudio.models.User;


import java.util.List;
import java.util.Optional;

public class UserService {

    public List<User> findAll() {
        return DaoPool.getUserDao().findAll();
    }

    public boolean save(User model) {
        return DaoPool.getUserDao().save(model);
    }

    public Optional<User> find(Integer id) {
        return DaoPool.getUserDao().find(id);
    }

    public boolean update(User model) {
        return DaoPool.getUserDao().update(model);
    }

    public boolean delete(Integer id) {
        return DaoPool.getUserDao().delete(id);
    }

    public Optional<User> findByUsername(String login) {
        return DaoPool.getUserDao().findByUsername(login);
    }
}


package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.User;

import java.util.Optional;

public interface MasterDao extends CrudDao<User> {
    Optional<User> findByName(String name);
}

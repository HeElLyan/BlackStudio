package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.Master;

import java.util.Optional;

public interface MasterDao extends CrudDao<Master> {
    Optional<Master> findByName(String name);
    Optional<Master> findById(int id);
}

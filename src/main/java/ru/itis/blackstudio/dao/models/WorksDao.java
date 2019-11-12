package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.Work;

import java.util.List;
import java.util.Optional;

public interface WorksDao extends CrudDao<Work> {
    Optional<Work> findByName(String name);
    Optional<Work> findById(int id);
    List<Work> findAllById(int id_master);
}

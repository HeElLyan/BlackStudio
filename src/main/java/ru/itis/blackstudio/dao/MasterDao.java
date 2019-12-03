package ru.itis.blackstudio.dao;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.Master;

import java.util.List;
import java.util.Optional;

public interface MasterDao extends CrudDao<Master> {

    //already written in crud
//    Optional<Master> findById(int id);
    Optional<Master> findByName(String name);
    Optional<Master> findByWorkingStyle(String workingStyle);

    List<Master> findAll();
}

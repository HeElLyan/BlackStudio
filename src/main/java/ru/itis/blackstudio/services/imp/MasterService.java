package ru.itis.blackstudio.services.imp;

import ru.itis.blackstudio.client.DaoPool;
import ru.itis.blackstudio.dao.MasterDao;
import ru.itis.blackstudio.models.Master;

import java.util.List;
import java.util.Optional;

public class MasterService {
    public Optional<Master> findMasterById (int masterId){
        MasterDao masterDao = DaoPool.getMasterDao();
        return masterDao.find(masterId);
    }

    public Optional<Master> findMasterByName (String name){
        MasterDao masterDao = DaoPool.getMasterDao();
        return masterDao.findByName(name);
    }

    public List<Master> findAll() {
        MasterDao masterDao = DaoPool.getMasterDao();
        return masterDao.findAll();
    }
}

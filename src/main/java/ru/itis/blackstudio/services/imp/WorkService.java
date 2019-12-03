package ru.itis.blackstudio.services.imp;

import ru.itis.blackstudio.client.DaoPool;
import ru.itis.blackstudio.dao.WorkDao;
import ru.itis.blackstudio.models.Work;

import java.util.List;
import java.util.Optional;

public class WorkService {
    public Optional<Work> findMasterById (int masterId){
        WorkDao workDao = DaoPool.getWorkDao();
        return workDao.find(masterId);
    }

    public boolean save(Work work) {
        WorkDao workDao = DaoPool.getWorkDao();
        return workDao.save(work);
    }


    public List<Work> findAll() {
        WorkDao workDao = DaoPool.getWorkDao();
        return workDao.findAll();
    }
}

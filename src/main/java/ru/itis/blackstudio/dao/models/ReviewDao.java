package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.Review;

public interface ReviewDao extends CrudDao<Review> {
    void insert(int id_master, int id_client, String review);
}

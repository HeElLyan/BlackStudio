package ru.itis.blackstudio.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<T> find(Integer id);
    void save(T model);
    void update(T model);
    void delete(T model);
    void insert(String username, String name, String password, String email, String phone, String birth_date, String city, String session, int stars, String time_signup);

    List<T> findAll();

    class MasterDao {
    }
}

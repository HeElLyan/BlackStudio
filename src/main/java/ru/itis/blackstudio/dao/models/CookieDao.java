package ru.itis.blackstudio.dao.models;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.models.Cookie;
import ru.itis.blackstudio.models.UserPass;

import java.util.Optional;

public interface CookieDao extends CrudDao {
    Optional<Cookie> compareValue(String decode);
    boolean delete(int id_client);
    String add(UserPass usps);
}

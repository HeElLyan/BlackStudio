package ru.itis.blackstudio.services;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.models.UserDao;
import ru.itis.blackstudio.dao.JDBC.UsersDaoJDBC;
import ru.itis.blackstudio.models.User;

import java.util.Optional;

public class Auth {
    public Optional<User> signIn (String username, String password){
        UserDao userDao = new UsersDaoJDBC(Singletons.getConnection());
        Optional<User> user = userDao.findByUsername(username);
        if(user.isPresent() && password.equals(user.get().getPassword())){
            return user;
        }
        return Optional.empty();
    }

    public void signUp(String username, String password, String name, String email, String phone, String birth_date) {
        UserDao userDao = new UsersDaoJDBC(Singletons.getConnection());
        userDao.insert(username, password, name, email, phone, birth_date);
    }
}

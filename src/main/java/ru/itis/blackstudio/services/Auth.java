package ru.itis.blackstudio.services;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.UsersDao;
import ru.itis.blackstudio.dao.UsersDaoJDBC;
import ru.itis.blackstudio.models.User;

import java.util.Optional;

public class Auth {
    public Optional<User> signIn (String username, String password){
        UsersDao usersDao = new UsersDaoJDBC(Singletons.getConnection());
        Optional<User> user = usersDao.findByUsername(username);
        if(user.isPresent() && password.equals(user.get().getPassword())){
            return user;
        }
        return Optional.empty();

    }
}

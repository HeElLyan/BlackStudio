package ru.itis.blackstudio.services;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.models.UsersDao;
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

    public void signUp(String username, String name, String password, String email, String phone, String birth_date, String city, String session, int stars, String time_signup) {
        UsersDao usersDao = new UsersDaoJDBC(Singletons.getConnection());
        usersDao.insert(username, name, password, email, phone, birth_date, city, session, stars, time_signup);
    }
}

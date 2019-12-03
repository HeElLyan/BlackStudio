package ru.itis.blackstudio.services.imp;

import ru.itis.blackstudio.client.DaoPool;
import ru.itis.blackstudio.exceptions.IncorrectLoginOrPasswordException;
import ru.itis.blackstudio.exceptions.NonUniqueLoginException;
import ru.itis.blackstudio.dao.UserDao;
import ru.itis.blackstudio.models.User;

import java.util.Optional;

public class Auth {

    public User signIn (String username, String password) throws IncorrectLoginOrPasswordException {
        UserDao userDao = DaoPool.getUserDao();
        Optional<User> user = userDao.findByUsername(username);
        if(user.isPresent() && password.equals(user.get().getPassword())){
            return user.get();
        } else {
            throw new IncorrectLoginOrPasswordException();
        }
    }

//    public void signUp(String username, String password, String name, String email, String phone, String birth_date) {
//        UserDao userDao = DaoPool.getUserDao();
//        userDao.insert(username, password, name, email, phone, birth_date);
//    }

    public boolean signUp(User user) throws NonUniqueLoginException {
        String  login = user.getUsername();
        UserDao userDao = DaoPool.getUserDao();
        if (userDao.isUnique(login)) {
            return userDao.save(user);
        } else {
            throw new NonUniqueLoginException();
        }
    }
}

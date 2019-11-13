package ru.itis.blackstudio.models;

import ru.itis.blackstudio.services.Hash;

public class UserPass {

    private String username;
    private String password;

    public UserPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(UserPass o) {
        return username.equals(o.username) &&
                password.equals(o.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public String hashCookie() {
        return Hash.getMd5Apache(username + "&" + password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

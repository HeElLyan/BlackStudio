package ru.itis.blackstudio.models;

public class Rating {
    private Master master;
    private User user;
    private int stars;

    public Rating(Master master, User user, int stars) {
        this.master = master;
        this.user = user;
        this.stars = stars;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

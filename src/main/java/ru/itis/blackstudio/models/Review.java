package ru.itis.blackstudio.models;

public class Review {
    private Master master;
    private User user;
    private String review;

    public Review(Master master, User user, String review) {
        this.master = master;
        this.user = user;
        this.review = review;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

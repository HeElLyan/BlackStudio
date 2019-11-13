package ru.itis.blackstudio.models;

public class Review {
    private int id_master;
    private int id_client;
    private String review;

    public Review(int id_master, int id_client, String review) {
        this.id_master = id_master;
        this.id_client = id_client;
        this.review = review;
    }

    public Review(int id_client, String review) {
        this.id_client = id_client;
        this.review = review;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    //    public Review(Master master, User user, String review) {
//        this.master = master;
//        this.user = user;
//        this.review = review;
//    }
//
//    public Master getMaster() {
//        return master;
//    }
//
//    public void setMaster(Master master) {
//        this.master = master;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
}

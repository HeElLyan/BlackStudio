package ru.itis.blackstudio.models;

import java.util.Date;

public class Review {
    private Integer id;
    private Integer masterId;
    private Integer clientId;
    private String review;
    private Integer rating;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public Review setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Review setDate(String date) {
        this.date = date;
        return this;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public Review setMasterId(Integer masterId) {
        this.masterId = masterId;
        return this;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Review setClientId(Integer clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getReview() {
        return review;
    }

    public Review setReview(String review) {
        this.review = review;
        return this;
    }
}

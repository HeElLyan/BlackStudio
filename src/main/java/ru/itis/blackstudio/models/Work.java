package ru.itis.blackstudio.models;

public class Work {
    private Integer id;
    private Integer masterId;
    private String urlWork;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public Work setMasterId(Integer masterId) {
        this.masterId = masterId;
        return this;
    }

    public String getUrlWork() {
        return urlWork;
    }

    public Work setUrlWork(String urlWork) {
        this.urlWork = urlWork;
        return this;
    }
}

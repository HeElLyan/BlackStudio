package ru.itis.blackstudio.models;

public class Work {
    private int id_master;
    private String url_work;

    public Work(int id_master, String url_work) {
        this.id_master = id_master;
        this.url_work = url_work;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public String getUrl_work() {
        return url_work;
    }

    public void setUrl_work(String url_work) {
        this.url_work = url_work;
    }
}

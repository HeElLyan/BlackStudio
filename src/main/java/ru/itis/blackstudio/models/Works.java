package ru.itis.blackstudio.models;

public class Works {
    private int id_master;
    private String url_work;
    private Master master;

    public Works(int id_master, String url_work, Master master) {
        this.id_master = id_master;
        this.url_work = url_work;
        this.master = master;
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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}

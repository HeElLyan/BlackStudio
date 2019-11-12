package ru.itis.blackstudio.models;

import java.util.List;

public class Master {
    private int id_master;
    private String name;
    private String working_style;
    private String photo_url;
    private List<Work> works;

    public Master(String name, String working_style) {
        this.name = name;
        this.working_style = working_style;
    }

    public Master(int id_master, String name) {
        this.id_master = id_master;
        this.name = name;
    }

    public Master(int id_master, String name, String working_style) {
        this.id_master = id_master;
        this.name = name;
        this.working_style = working_style;
    }

    public Master(int id_master, String name, String working_style, String photo_url, List<Work> works) {
        this.id_master = id_master;
        this.name = name;
        this.working_style = working_style;
        this.photo_url = photo_url;
        this.works = works;
    }

    public Master(int id_master, String name, String photo_url, String working_style) {
        this.id_master = id_master;
        this.name = name;
        this.working_style = working_style;
        this.photo_url = photo_url;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorking_style() {
        return working_style;
    }

    public void setWorking_style(String working_style) {
        this.working_style = working_style;
    }
}

package ru.itis.blackstudio.models;

import java.util.List;

public class Master {
    private Integer id;
    private String name;
    private String working_style;
    private String photo_url;
    private List<Works> works;

    public Master(String name, String working_style) {
        this.name = name;
        this.working_style = working_style;
    }

    public Master(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Master(Integer id, String name, String working_style) {
        this.id = id;
        this.name = name;
        this.working_style = working_style;
    }

    public Master(Integer id, String name, String working_style, String photo_url, List<Works> works) {
        this.id = id;
        this.name = name;
        this.working_style = working_style;
        this.photo_url = photo_url;
        this.works = works;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public List<Works> getWorks() {
        return works;
    }

    public void setWorks(List<Works> works) {
        this.works = works;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

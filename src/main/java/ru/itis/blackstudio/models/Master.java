package ru.itis.blackstudio.models;

import java.util.List;

public class Master {
    private int masterId;
    private String name;
    private String workingStyle;
    private String urlPhoto;
    private Long phone;
    private Integer experience;
    private List<Work> works;


    public Long getPhone() {
        return phone;
    }

    public Master setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public Master setExperience(Integer experience) {
        this.experience = experience;
        return this;
    }

    public Integer getExperience() {
        return experience;
    }

    public int getMasterId() {
        return masterId;
    }

    public Master setMasterId(int masterId) {
        this.masterId = masterId;
        return this;
    }


    public String getUrlPhoto() {
        return urlPhoto;
    }

    public Master setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this;
    }

    public String getName() {
        return name;
    }

    public Master setName(String name) {
        this.name = name;
        return this;
    }

    public String getWorkingStyle() {
        return workingStyle;
    }

    public Master setWorkingStyle(String workingStyle) {
        this.workingStyle = workingStyle;
        return this;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

}

package ru.itis.blackstudio.models;

public class Master {
    private Integer id;
    private String name;
    private int phone;
    private String email;
    private String instagram;
    private String vk;
    private int experience;
    private String url_works;
    private String birth_date;
    private String city;
    private String working_style;

    public Master(String name, String working_style) {
        this.name = name;
        this.working_style = working_style;
    }

    public Master(Integer id, String name, String working_style) {
        this.id = id;
        this.name = name;
        this.working_style = working_style;
    }

    public Master(String name, int phone, String email, String instagram, String vk, int experience, String url_works, String birth_date, String city, String working_style) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.instagram = instagram;
        this.vk = vk;
        this.experience = experience;
        this.url_works = url_works;
        this.birth_date = birth_date;
        this.city = city;
        this.working_style = working_style;
    }

    public Master(Integer id, String name, int phone, String email, String instagram, String vk, int experience, String url_works, String birth_date, String city, String working_style) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.instagram = instagram;
        this.vk = vk;
        this.experience = experience;
        this.url_works = url_works;
        this.birth_date = birth_date;
        this.city = city;
        this.working_style = working_style;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getUrl_works() {
        return url_works;
    }

    public void setUrl_works(String url_works) {
        this.url_works = url_works;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorking_style() {
        return working_style;
    }

    public void setWorking_style(String working_style) {
        this.working_style = working_style;
    }
}

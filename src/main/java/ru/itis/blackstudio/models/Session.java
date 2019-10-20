package ru.itis.blackstudio.models;

public class Session {
    private Integer id;
    private String time;
    private User session;

    public Session(Integer id, String time, User session) {
        this.id = id;
        this.time = time;
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getSession() {
        return session;
    }

    public void setSession(User session) {
        this.session = session;
    }
}

package ru.itis.blackstudio.models;

public class Session {
    private Integer id;
    private String time;
    private User userSession;
    private Master masterTimetable;

    public Session(Integer id, String time, User userSession, Master masterTimetable) {
        this.id = id;
        this.time = time;
        this.userSession = userSession;
        this.masterTimetable = masterTimetable;
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

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }

    public Master getMasterTimetable() {
        return masterTimetable;
    }

    public void setMasterTimetable(Master masterTimetable) {
        this.masterTimetable = masterTimetable;
    }
}

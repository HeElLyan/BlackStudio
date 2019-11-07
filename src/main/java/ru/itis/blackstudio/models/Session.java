package ru.itis.blackstudio.models;

public class Session {
    private Integer id;
    private String time;
    private User user_session;
    private Master master_timetable;

    public Session(Integer id, String time, User user_session, Master master_timetable) {
        this.id = id;
        this.time = time;
        this.user_session = user_session;
        this.master_timetable = master_timetable;
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

    public User getUser_session() {
        return user_session;
    }

    public void setUser_session(User user_session) {
        this.user_session = user_session;
    }

    public Master getMaster_timetable() {
        return master_timetable;
    }

    public void setMaster_timetable(Master master_timetable) {
        this.master_timetable = master_timetable;
    }
}

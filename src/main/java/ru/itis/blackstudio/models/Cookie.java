package ru.itis.blackstudio.models;

public class Cookie {
    private int id_cookie;
    private int id_client;
    private String hash;

    public Cookie(int id_client, String hash) {
        this.id_client = id_client;
        this.hash = hash;
    }

    public Cookie(int id_cookie, int id_client, String hash) {
        this.id_cookie = id_cookie;
        this.id_client = id_client;
        this.hash = hash;
    }

    public int getId_cookie() {
        return id_cookie;
    }

    public void setId_cookie(int id_cookie) {
        this.id_cookie = id_cookie;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}

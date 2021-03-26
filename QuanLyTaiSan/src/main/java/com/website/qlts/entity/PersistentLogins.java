package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class PersistentLogins implements Serializable {
    @Size(min = 6, max = 255)
    private String userName;

    @Size(min = 6, max = 255)
    private String series;

    @Size(min = 6, max = 255)
    private String token;

    @Size(min = 6, max = 255)
    private String lastUsed;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public PersistentLogins(String userName, String series, String token, String lastUsed) {
        this.userName = userName;
        this.series = series;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public PersistentLogins() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(String lastUsed) {
        this.lastUsed = lastUsed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

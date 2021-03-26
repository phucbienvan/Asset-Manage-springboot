package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class GroupAssets implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String groupName;

    private int is_deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public GroupAssets(String groupName, int is_deleted) {
        this.groupName = groupName;
        this.is_deleted = is_deleted;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public GroupAssets() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

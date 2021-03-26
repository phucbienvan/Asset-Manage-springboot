package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class CategoryAssets implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String name;

    private int is_deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public CategoryAssets(String name, int is_deleted) {
        this.name = name;
        this.is_deleted = is_deleted;
    }

    public CategoryAssets() {
        this.id = 0;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

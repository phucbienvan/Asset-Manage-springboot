package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    private int is_deleted;

    @NotEmpty(message = "Không được để trống")
//    @Size(max = 255, min = 6)
    private String departmentName;

    private long parentId;
//
//    private int chilId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Departments() {
    }

    public Departments(int is_deleted, String departmentName) {
        this.is_deleted = is_deleted;
        this.departmentName = departmentName;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

//    public int getChilId() {
//        return chilId;
//    }
//
//    public void setChilId(int chilId) {
//        this.chilId = chilId;
//    }
}

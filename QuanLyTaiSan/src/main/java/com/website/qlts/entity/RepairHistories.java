package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RepairHistories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "asset_id", unique = false)
    private long assetId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Column(name = "department_id", unique = false)
    private long departmentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, insertable = false, unique = false)
    private Departments departments;

    @Column(name = "staff_id", unique = false)
    private long staffId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", updatable = false, insertable = false, unique = false)
    private Staffs staffs;

    private Date endAt;

    private Date startAt;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String description;

    @Column(name = "isDeleted")
    private int is_deleted;

    public RepairHistories(long assetId, Assets assets, long departmentId, Departments departments, long staffId, Staffs staffs, Date endAt, Date startAt) {
        this.assetId = assetId;
        this.assets = assets;
        this.departmentId = departmentId;
        this.departments = departments;
        this.staffId = staffId;
        this.staffs = staffs;
        this.endAt = endAt;
        this.startAt = startAt;
    }

    public RepairHistories() {
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }
}

package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RevokeHistories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "asset_id", unique = false)
    private long assetId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Column(name = "staff_id", unique = false)
    private long staffId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", updatable = false, insertable = false, unique = false)
    private Staffs staffs;

    @Column(name = "department_id", unique = false)
    private long departmentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, insertable = false, unique = false)
    private Departments departments;
    public RevokeHistories() {
    }

    public RevokeHistories(long assetId, long staffId, long departmentId, String reason, int status, Date revokeDate, int is_deleted) {
        this.assetId = assetId;
        this.staffId = staffId;
        this.departmentId = departmentId;
        this.reason = reason;
        this.status = status;
        this.revokeDate = revokeDate;
        this.is_deleted = is_deleted;
    }
    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String reason;

    private int status;
    private Date revokeDate;
    private int is_deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Date getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(Date revokeDate) {
        this.revokeDate = revokeDate;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}

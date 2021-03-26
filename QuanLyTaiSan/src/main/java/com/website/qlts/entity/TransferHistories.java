package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class TransferHistories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "asset_id", unique = false)
    private long assetId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Column(name = "staff_id_old", unique = false)
    private long staffIdOld;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id_old", updatable = false, insertable = false, unique = false)
    private Staffs staffs;

    @Column(name = "staff_id_new", unique = false)
    private long staffIdNew;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id_new", updatable = false, insertable = false, unique = false)
    private Staffs staff;

    @Column(name = "department_id_old", unique = false)
    private long departmentIdOld;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id_old", updatable = false, insertable = false, unique = false)
    private Departments departments;

    @Column(name = "department_id_new", unique = false)
    private long departmentIdNew;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id_new", updatable = false, insertable = false, unique = false)
    private Departments department;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String reason;

    private int status;
    private Date startDate;
    private Date endDate;
    private int is_deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public TransferHistories() {
    }

    public TransferHistories(long assetId, long staffIdOld, long staffIdNew, long departmentIdOld, long departmentIdNew, String reason, int status, Date startDate, Date endDate, int is_deleted) {
        this.assetId = assetId;
        this.staffIdOld = staffIdOld;
        this.staffIdNew = staffIdNew;
        this.departmentIdOld = departmentIdOld;
        this.departmentIdNew = departmentIdNew;
        this.reason = reason;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.is_deleted = is_deleted;
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

    public long getStaffIdOld() {
        return staffIdOld;
    }

    public void setStaffIdOld(long staffIdOld) {
        this.staffIdOld = staffIdOld;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public long getStaffIdNew() {
        return staffIdNew;
    }

    public void setStaffIdNew(long staffIdNew) {
        this.staffIdNew = staffIdNew;
    }

    public Staffs getStaff() {
        return staff;
    }

    public void setStaff(Staffs staff) {
        this.staff = staff;
    }

    public long getDepartmentIdOld() {
        return departmentIdOld;
    }

    public void setDepartmentIdOld(long departmentIdOld) {
        this.departmentIdOld = departmentIdOld;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public long getDepartmentIdNew() {
        return departmentIdNew;
    }

    public void setDepartmentIdNew(long departmentIdNew) {
        this.departmentIdNew = departmentIdNew;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}

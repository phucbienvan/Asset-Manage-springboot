package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Assets implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 255)
    private String codeAsset;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String name;


    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String description;

    private int amount;

    @NotEmpty(message = "Không được để trống")
    private String conditionAsset;
    private int status;
    private long price;
    private String pathImage;

//    @NotEmpty(message = "Không được để trống")
//    @Size(max = 255)
    private String position;

    @Column(name = "department_id", unique = false)
    private long department_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, insertable = false, unique = false)
    private Departments departments;

    @Column(name = "asset_category_id", unique = false)
    private long asset_category_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_category_id", updatable = false, insertable = false, unique = false)
    private CategoryAssets categoryAssets;

    @Column(name = "group_assets_id", unique = false)
    private long group_assets_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_assets_id", updatable = false, insertable = false, unique = false)
    private GroupAssets groupAssets;

    @Column(name = "supplier_id", unique = false)
    private long supplier_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", updatable = false, insertable = false, unique = false)
    private Suppliers suppliers;

    @Column(name = "staff_id", unique = false)
    private long staff_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", updatable = false, insertable = false, unique = false)
    private Staffs staffs;

    private int cateMoney;
    private long sellPrice;
    private long updatedById;
    private long deletedById;
    private int is_deleted;
    private Date updatedDate;
    private Date modifiedDate;
    private Date createDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Assets(String name, String description, int amount, String conditionAsset, int status, long price, String position, long asset_category_id, long group_assets_id, long supplier_id,int is_deleted,Date updatedDate,Date createDate, int cateMoney, String codeAsset) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.conditionAsset = conditionAsset;
        this.status = status;
        this.price = price;
        this.position = position;
        this.asset_category_id = asset_category_id;
        this.group_assets_id = group_assets_id;
        this.supplier_id = supplier_id;
        this.is_deleted = is_deleted;
        this.updatedDate = updatedDate;
        this.createDate = createDate;
        this.cateMoney = cateMoney;
        this.codeAsset = codeAsset;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getCodeAsset() {
        return codeAsset;
    }

    public void setCodeAsset(String codeAsset) {
        this.codeAsset = codeAsset;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getAsset_category_id() {
        return asset_category_id;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setAsset_category_id(long asset_category_id) {
        this.asset_category_id = asset_category_id;
    }

    public CategoryAssets getCategoryAssets() {
        return categoryAssets;
    }

    public void setCategoryAssets(CategoryAssets categoryAssets) {
        this.categoryAssets = categoryAssets;
    }

    public Assets() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getConditionAsset() {
        return conditionAsset;
    }

    public void setConditionAsset(String conditionAsset) {
        this.conditionAsset = conditionAsset;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public long getAssets_id() {
        return asset_category_id;
    }

    public void setAssets_id(long assets_id) {
        this.asset_category_id = assets_id;
    }


    public long getGroup_assets_id() {
        return group_assets_id;
    }

    public void setGroup_assets_id(long group_assets_id) {
        this.group_assets_id = group_assets_id;
    }

    public GroupAssets getGroupAssets() {
        return groupAssets;
    }

    public void setGroupAssets(GroupAssets groupAssets) {
        this.groupAssets = groupAssets;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(long updatedById) {
        this.updatedById = updatedById;
    }

    public long getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(long deletedById) {
        this.deletedById = deletedById;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public int getCateMoney() {
        return cateMoney;
    }

    public void setCateMoney(int cateMoney) {
        this.cateMoney = cateMoney;
    }
}

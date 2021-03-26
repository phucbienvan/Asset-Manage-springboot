package com.website.qlts.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class SellAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "asset_id", unique = false)
    private long assetId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Size(min = 6, max = 255)
    private String name;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 11)
    private String phoneNumber;
    private long priceSell;

    @NotEmpty(message = "Không được để trống")
    @Size(max = 255)
    private String note;
    private Date createdDate;
    private int isDeleted;

    public SellAsset(long assetId, String name, String phoneNumber, long priceSell, String note,Date createdDate, int isDeleted) {
        this.assetId = assetId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.priceSell = priceSell;
        this.note = note;
        this.createdDate = createdDate;
        this.isDeleted = isDeleted;
    }

    public SellAsset() {
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(long priceSell) {
        this.priceSell = priceSell;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}

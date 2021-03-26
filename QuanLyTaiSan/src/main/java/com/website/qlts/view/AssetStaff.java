package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Staffs;
import com.website.qlts.service.StaffService;

import java.util.List;

public class AssetStaff {
    List<Assets> assetsList;
    List<Staffs>  staffsList;

    public AssetStaff(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public AssetStaff() {
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public List<Staffs> getStaffsList() {
        return staffsList;
    }

    public void setStaffsList(List<Staffs> staffsList) {
        this.staffsList = staffsList;
    }
}

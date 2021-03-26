package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Departments;

import java.util.List;

public class AssetDepartment {
    List<Assets> assetsList;
    List<Departments> departmentsList;

    public AssetDepartment(List<Assets> assetsList, List<Departments> departmentsList) {
        this.assetsList = assetsList;
        this.departmentsList = departmentsList;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public AssetDepartment() {
    }
}

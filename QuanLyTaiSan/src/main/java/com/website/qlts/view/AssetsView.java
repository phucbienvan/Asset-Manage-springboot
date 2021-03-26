package com.website.qlts.view;

import com.website.qlts.entity.*;

import java.util.List;

public class AssetsView {
    private Assets assets;
    private List<Assets> assetsList;
    private List<GroupAssets> groupAssetsList;
    private List<CategoryAssets> categoryAssetsList;
    private List<Departments> departmentsList;
    private List<Suppliers> suppliersList;

    public AssetsView(Assets assets, List<GroupAssets> groupAssetsList, List<CategoryAssets> categoryAssetsList, List<Departments> departmentsList, List<Suppliers> suppliersList) {
        this.assets = assets;
        this.groupAssetsList = groupAssetsList;
        this.categoryAssetsList = categoryAssetsList;
        this.departmentsList = departmentsList;
        this.suppliersList = suppliersList;
    }

    public AssetsView() {
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public List<GroupAssets> getGroupAssetsList() {
        return groupAssetsList;
    }

    public void setGroupAssetsList(List<GroupAssets> groupAssetsList) {
        this.groupAssetsList = groupAssetsList;
    }

    public List<CategoryAssets> getCategoryAssetsList() {
        return categoryAssetsList;
    }

    public void setCategoryAssetsList(List<CategoryAssets> categoryAssetsList) {
        this.categoryAssetsList = categoryAssetsList;
    }

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public List<Suppliers> getSuppliersList() {
        return suppliersList;
    }

    public void setSuppliersList(List<Suppliers> suppliersList) {
        this.suppliersList = suppliersList;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }
}

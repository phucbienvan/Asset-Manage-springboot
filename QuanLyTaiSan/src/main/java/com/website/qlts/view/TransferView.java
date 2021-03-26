package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Departments;
import com.website.qlts.entity.Staffs;
import com.website.qlts.entity.TransferHistories;

import java.util.List;

public class TransferView {
    private Assets assets;
    private TransferHistories transferHistories;
    private List<Staffs> staffsListOld;
    private List<Assets> assetsListOld;
    private List<Staffs> staffsListNew;
    private List<Assets> assetsListNew;
    private List<Departments> departmentsListOld;
    private List<Departments> departmentsListNew;

    public TransferHistories getTransferHistories() {
        return transferHistories;
    }

    public void setTransferHistories(TransferHistories transferHistories) {
        this.transferHistories = transferHistories;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public List<Departments> getDepartmentsListOld() {
        return departmentsListOld;
    }

    public void setDepartmentsListOld(List<Departments> departmentsListOld) {
        this.departmentsListOld = departmentsListOld;
    }

    public List<Departments> getDepartmentsListNew() {
        return departmentsListNew;
    }

    public void setDepartmentsListNew(List<Departments> departmentsListNew) {
        this.departmentsListNew = departmentsListNew;
    }

    public List<Staffs> getStaffsListOld() {
        return staffsListOld;
    }

    public void setStaffsListOld(List<Staffs> staffsListOld) {
        this.staffsListOld = staffsListOld;
    }

    public List<Assets> getAssetsListOld() {
        return assetsListOld;
    }

    public void setAssetsListOld(List<Assets> assetsListOld) {
        this.assetsListOld = assetsListOld;
    }

    public List<Staffs> getStaffsListNew() {
        return staffsListNew;
    }

    public void setStaffsListNew(List<Staffs> staffsListNew) {
        this.staffsListNew = staffsListNew;
    }

    public List<Assets> getAssetsListNew() {
        return assetsListNew;
    }

    public void setAssetsListNew(List<Assets> assetsListNew) {
        this.assetsListNew = assetsListNew;
    }
}

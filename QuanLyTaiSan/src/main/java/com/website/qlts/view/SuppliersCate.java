package com.website.qlts.view;

import com.website.qlts.entity.CategoriesSuppliers;
import com.website.qlts.entity.Suppliers;

import java.util.List;

public class SuppliersCate {
    private Suppliers suppliers;
    private List<CategoriesSuppliers> list;

    public SuppliersCate(Suppliers suppliers, List<CategoriesSuppliers> list) {
        this.suppliers = suppliers;
        this.list = list;
    }

    public SuppliersCate() {
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public List<CategoriesSuppliers> getList() {
        return list;
    }

    public void setList(List<CategoriesSuppliers> list) {
        this.list = list;
    }
}

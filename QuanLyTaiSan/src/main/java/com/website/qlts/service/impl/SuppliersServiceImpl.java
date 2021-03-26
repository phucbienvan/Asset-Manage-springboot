package com.website.qlts.service.impl;

import com.website.qlts.entity.CategoriesSuppliers;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.repository.SuppliersReposiotory;
import com.website.qlts.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersServiceImpl implements SuppliersService {
    @Autowired
    SuppliersReposiotory suppliersReposiotory;

    public List<Suppliers> getAll() {
        return suppliersReposiotory.getAll();
    }

    public List<Suppliers> getByName(String name) {
        List<Suppliers> assetsList = suppliersReposiotory.getByName(name);
        return assetsList;
    }

    public List<CategoriesSuppliers> getCate() {
        List<CategoriesSuppliers> categoriesSuppliers = suppliersReposiotory.getCate();
        return categoriesSuppliers;
    }

    public Suppliers create(String name, String address, String phoneNumber, long id) {
        Suppliers suppliers = new Suppliers(name, address, phoneNumber, id,0);
        return suppliersReposiotory.save(suppliers);
    }

    public void update(long id, Suppliers suppliers) {
        Suppliers suppliers1 = suppliersReposiotory.findById(id).orElse(null);
        suppliers1.setName(suppliers.getName());
        suppliers1.setAddress(suppliers.getAddress());
        suppliers1.setPhoneNumber(suppliers.getPhoneNumber());
        suppliers1.setSupplier_category_id(suppliers.getSupplier_category_id());
        suppliersReposiotory.save(suppliers1);
    }

    public Suppliers getById(long id) {
        return suppliersReposiotory.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        Suppliers suppliers = suppliersReposiotory.findById(id).orElse(null);
        if (suppliers != null) {
            suppliers.setIs_deleted(1);
            suppliersReposiotory.save(suppliers);
        }

    }

}

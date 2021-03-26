package com.website.qlts.service;

import com.website.qlts.entity.CategoriesSuppliers;
import com.website.qlts.entity.Suppliers;

import java.util.List;
public interface SuppliersService {
    public List<Suppliers> getAll() ;

    public List<Suppliers> getByName(String name);

    public List<CategoriesSuppliers> getCate();

    public Suppliers create(String name, String address, String phoneNumber, long id);

    public void update(long id,Suppliers suppliers);

    public Suppliers getById(long id);

    public void delete(long id);
}

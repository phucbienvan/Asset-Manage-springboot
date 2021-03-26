package com.website.qlts.service;

import com.website.qlts.entity.CategoriesSuppliers;

import java.util.List;


public interface CategorySuppliersService {
    public CategoriesSuppliers create(String name);

    public List<CategoriesSuppliers> getAll();

    public CategoriesSuppliers getById(long id);

    public void update(long id, String name);

    public void delete(long id);

    public List<CategoriesSuppliers> getByName(String name);
}

package com.website.qlts.service.impl;

import com.website.qlts.entity.CategoriesSuppliers;
import com.website.qlts.repository.CategorySuppliersRepository;
import com.website.qlts.service.CategorySuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorySuppliersServiceImpl implements CategorySuppliersService {
    @Autowired
    CategorySuppliersRepository categorySuppliersRepository;

    public CategoriesSuppliers create(String name) {
        return categorySuppliersRepository.save(new CategoriesSuppliers(name,0));
    }

    public List<CategoriesSuppliers> getAll() {
        return categorySuppliersRepository.getAll();
    }

    public CategoriesSuppliers getById(long id) {
        return categorySuppliersRepository.findById(id).orElse(null);
    }

    public void update(long id, String name) {
        Optional<CategoriesSuppliers> categoryAssets = categorySuppliersRepository.findById(id);
        categoryAssets.get().setName(name);
        categorySuppliersRepository.save(categoryAssets.get());
    }

    public void delete(long id) {
        CategoriesSuppliers categoryAssets = categorySuppliersRepository.findById(id).orElse(null);
        if(categoryAssets != null){
            categoryAssets.setIs_deleted(1);
            categorySuppliersRepository.save(categoryAssets);
        }

    }

    public List<CategoriesSuppliers> getByName(String name) {
        List<CategoriesSuppliers> assetsList = categorySuppliersRepository.getByName(name);
        return assetsList;
    }
}

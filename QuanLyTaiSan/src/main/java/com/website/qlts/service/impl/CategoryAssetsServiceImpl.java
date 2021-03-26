package com.website.qlts.service.impl;

import com.website.qlts.entity.CategoryAssets;
import com.website.qlts.repository.CategoryAssetsRepository;
import com.website.qlts.service.CategoryAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryAssetsServiceImpl implements CategoryAssetsService {
    @Autowired
    CategoryAssetsRepository categoryAssetsRepository;

    public CategoryAssets create(String name) {
        return categoryAssetsRepository.save(new CategoryAssets(name, 0));
    }

    public List<CategoryAssets> getAll() {
        return categoryAssetsRepository.getAll();
    }

    public CategoryAssets getById(long id) {
        return categoryAssetsRepository.findById(id).orElse(null);
    }

    public void update(long id, String name) {
        Optional<CategoryAssets> categoryAssets = categoryAssetsRepository.findById(id);
        categoryAssets.get().setName(name);
        categoryAssetsRepository.save(categoryAssets.get());
    }

    public void delete(long id) {
        CategoryAssets categoryAssets = categoryAssetsRepository.findById(id).orElse(null);
        if (categoryAssets != null){
            categoryAssets.setIs_deleted(1);
            categoryAssetsRepository.delete(categoryAssets);
        }

    }

    public List<CategoryAssets> getByName(String name) {
        List<CategoryAssets> assetsList = categoryAssetsRepository.getByName(name);
        return assetsList;
    }
}

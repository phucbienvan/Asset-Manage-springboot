package com.website.qlts.service;

import com.website.qlts.entity.CategoryAssets;

import java.util.List;

public interface CategoryAssetsService {
    public CategoryAssets create(String name);

    public List<CategoryAssets> getAll();

    public CategoryAssets getById(long id);

    public void update(long id, String name);

    public void delete(long id);

    public List<CategoryAssets> getByName(String name);

}

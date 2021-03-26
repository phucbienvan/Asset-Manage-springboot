package com.website.qlts.service;

import com.website.qlts.entity.GroupAssets;

import java.util.List;
import java.util.Optional;

public interface GroupAssetsService {
    public GroupAssets create(String name);

    public List<GroupAssets> getAll();

    public GroupAssets getById(long id);

    public void update(long id, String name);

    public void delete(long id);

    public List<GroupAssets> getByName(String name);
}

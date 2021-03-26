package com.website.qlts.service;

import com.website.qlts.entity.SellAsset;

import java.util.List;

public interface SellAssetService {
    public  void createSellAsset(SellAsset sellAsset);

    public List<SellAsset> getAll();
}

package com.website.qlts.service.impl;

import com.website.qlts.entity.SellAsset;
import com.website.qlts.repository.SellAssetRepository;
import com.website.qlts.service.SellAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellAssetServiceImpl implements SellAssetService {
    @Autowired
    SellAssetRepository sellAssetRepository;
    public  void createSellAsset(SellAsset sellAsset){
        sellAssetRepository.save(sellAsset);
    }

    @Override
    public List<SellAsset> getAll() {
        return sellAssetRepository.getAll();
    }
}

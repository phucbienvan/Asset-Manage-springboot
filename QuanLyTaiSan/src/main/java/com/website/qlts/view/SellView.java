package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.SellAsset;

import java.util.List;

public class SellView {
    private Assets asset;
    private SellAsset sellAsset;

    public Assets getAsset() {
        return asset;
    }

    public void setAsset(Assets asset) {
        this.asset = asset;
    }

    public SellAsset getSellAsset() {
        return sellAsset;
    }

    public void setSellAsset(SellAsset sellAsset) {
        this.sellAsset = sellAsset;
    }
}

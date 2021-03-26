package com.website.qlts.service;

public interface HistoryService {
    public void update();

    public void addSell(long assetId, long price, int status);
}

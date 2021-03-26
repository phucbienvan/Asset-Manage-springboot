package com.website.qlts.service.impl;

import com.website.qlts.repository.HistoryRepository;
import com.website.qlts.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    @Override
    public void update() {

    }

    @Override
    public void addSell(long assetId, long price, int status) {

    }
}

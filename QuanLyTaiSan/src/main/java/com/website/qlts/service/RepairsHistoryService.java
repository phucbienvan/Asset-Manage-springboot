package com.website.qlts.service;

import com.website.qlts.entity.RepairHistories;

import java.util.List;

public interface RepairsHistoryService {
    void save(RepairHistories repairsHistory);
    List<RepairHistories> getAll();
}

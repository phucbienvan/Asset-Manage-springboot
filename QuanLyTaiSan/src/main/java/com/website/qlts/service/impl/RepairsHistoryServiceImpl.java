package com.website.qlts.service.impl;

import com.website.qlts.entity.RepairHistories;
import com.website.qlts.repository.RepairsHistoryRepository;
import com.website.qlts.service.RepairsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairsHistoryServiceImpl implements RepairsHistoryService {

    @Autowired
    private RepairsHistoryRepository repairsHistoryRepository;

    @Override
    public void save(RepairHistories repairsHistory){
        repairsHistoryRepository.save(repairsHistory);
    }

    @Override
    public List<RepairHistories> getAll(){
        return repairsHistoryRepository.getAll();
    }
}

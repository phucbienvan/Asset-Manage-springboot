package com.website.qlts.service.impl;

import com.website.qlts.entity.RevokeHistories;
import com.website.qlts.repository.RevokeHistoryRepository;
import com.website.qlts.service.RevokeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RevokeHistoryServiceImpl implements RevokeHistoryService {
    @Autowired
    RevokeHistoryRepository revokeHistoryRepository;

    @Override
    public void createHistory(long assetId, long staffId, long departmentId, String reason, Date revokeDate) {
        RevokeHistories revokeHistories = new RevokeHistories();
        revokeHistories.setAssetId(assetId);
        revokeHistories.setStaffId(staffId);
        revokeHistories.setDepartmentId(departmentId);
        revokeHistories.setReason(reason);
        revokeHistories.setRevokeDate(revokeDate);
        revokeHistoryRepository.save(revokeHistories);
    }

    @Override
    public List<RevokeHistories> getAll() {
        return revokeHistoryRepository.getAll();
    }

    @Override
    public List<RevokeHistories> getByDate(Date fromDate, Date toDate) {
        return revokeHistoryRepository.getByDate(fromDate,toDate);
    }

    @Override
    public List<RevokeHistories> getById(long id) {
        return revokeHistoryRepository.getById(id);
    }
}

package com.website.qlts.service;

import com.website.qlts.entity.RevokeHistories;

import java.util.Date;
import java.util.List;

public interface RevokeHistoryService {
    public  void createHistory(long assetId, long staffId, long departmentId, String reason, Date revokeDate);

    public List<RevokeHistories> getAll();

    public List<RevokeHistories> getByDate(Date fromDate, Date toDate);

    public List<RevokeHistories> getById(long id);
}

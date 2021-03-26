package com.website.qlts.service;

import com.website.qlts.entity.TransferHistories;

import java.util.Date;
import java.util.List;

public interface TransferService {
    public List<TransferHistories> getAll();

    public List<TransferHistories> getAllByDepartment();

    public List<TransferHistories> getAllByStaff();

    public TransferHistories getById(long id);

    public List<TransferHistories> getByDate(String fromDate, String toDate);

    public List<TransferHistories> getByName(String name);

    public List<TransferHistories> getListById(long id);

    public Date convertStringToDate(String dateString);
    public void createAndUpdate(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status);

    public void createAndUpdateWithStaff(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status);
}

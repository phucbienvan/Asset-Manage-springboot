package com.website.qlts.service.impl;

import com.website.qlts.entity.TransferHistories;
import com.website.qlts.repository.TransferRepository;
import com.website.qlts.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TransferRepository transferRepository;

    @Override
    public List<TransferHistories> getAll() {
        return transferRepository.getAll();
    }

    @Override
    public List<TransferHistories> getAllByDepartment() {
        return transferRepository.getAllByDepartment();
    }

    @Override
    public List<TransferHistories> getAllByStaff() {
        return transferRepository.getAllByStaff();
    }

    @Override
    public TransferHistories getById(long id) {
        return transferRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransferHistories> getByDate(String fromDate, String toDate) {
        return transferRepository.getAllByDate(convertStringToDate(fromDate),convertStringToDate(toDate));
    }

    @Override
    public List<TransferHistories> getByName(String name) {
        return transferRepository.getByName(name);
    }

    @Override
    public List<TransferHistories> getListById(long id) {
        return transferRepository.getListById(id);
    }

    @Override
    public Date convertStringToDate(String dateString) {
        String dateStringFormat = dateString.replace('-','/');
        Date date = new Date();
        try {
            date=new SimpleDateFormat("yyyy/MM/dd").parse(dateStringFormat);
        }catch (Exception ex){
        }
        return date;
    }

    @Override
    public void createAndUpdate(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status) {
        TransferHistories transferHistories = new TransferHistories();
        transferHistories.setAssetId(assetId);
        transferHistories.setDepartmentIdOld(oldDepartmentId);
        transferHistories.setDepartmentIdNew(newDepartmentId);
        transferHistories.setStartDate(startDate);
        transferHistories.setEndDate(endDate);
        transferHistories.setStatus(status);
        transferHistories.setReason(reason);
        transferRepository.save(transferHistories);
    }

    @Override
    public void createAndUpdateWithStaff(String reason, long assetId, long oldStaff, long newStaff, Date startDate, Date endDate, int status) {
        TransferHistories transferHistories = new TransferHistories();
        transferHistories.setAssetId(assetId);
        transferHistories.setStaffIdOld(oldStaff);
        transferHistories.setStaffIdNew(newStaff);
        transferHistories.setStartDate(startDate);
        transferHistories.setEndDate(endDate);
        transferHistories.setStatus(status);
        transferHistories.setReason(reason);
        transferRepository.save(transferHistories);
    }
}

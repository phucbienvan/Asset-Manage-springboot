package com.website.qlts.service;

import com.website.qlts.entity.Assets;
import com.website.qlts.view.AssetsView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface AssetsService {

    public  ArrayList<Long> listIntId = new ArrayList<>();

    public  ArrayList<Long> listPrice = new ArrayList<>();

    public  void updateRepair(long id);

    public  void updateStatus(long id);

    public void updateStatusRevoke(long id);

    public void assetSell();

    public List<Assets> getAssetsNew(int month, int year);

    public  List<Assets> getByName(String name);

    public List<Assets> getByStatus(int status);

    public List<Assets> getByDeparment(long id);

    public List<Assets> getByGroupAsset(long id);

    public List<Assets> getByCateAsset(long id);

    public List<Assets> sell(String listId, String price);

    public List<Assets> getAll();

    public List<Assets> getAssetsNoRevoke();

    public List<Assets> getAllWithDepart();

    public List<Assets> getAllWithStaff();

    public List<Assets> getAssetsNoUse();

    public void create(String name, String description, int amount, String condition, int status, long price, String position,  long cateId, long groupId, long suppId, int cateMoney,String uri, String url);

    public Assets findById(long id);

    public String makeUrl(String uri, String url, long id);

    public void delete(long id);

    public void update(long id, AssetsView assetsView, long suppliersId,long departmentsId, long groupAssetsId, long categoryAssetsId);

    public void updateTransferDepart(long id,long departmentId, Date date);

    public void updateTransferStaff(long id,long staffId, Date date);

    public List<Long> getListIdByName(String name);


}

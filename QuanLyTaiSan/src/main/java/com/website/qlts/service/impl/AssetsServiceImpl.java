package com.website.qlts.service.impl;

import com.website.qlts.config.CreateQRCodeConfig;
import com.website.qlts.entity.Assets;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.AssetsService;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    AssetsRepository assetsRepository;

    @Override
    public void updateRepair(long id) {
        Assets assets = findById(id);
        assets.setStatus(5);
        assetsRepository.save(assets);
    }

    @Override
    public void updateStatus(long id) {
        Assets assets = findById(id);
        assets.setStatus(4);
        assetsRepository.save(assets);
    }

    @Override
    public void updateStatusRevoke(long id) {
        Assets assets = findById(id);
        assets.setStatus(3);
        assetsRepository.save(assets);
    }

    @Override
    public void assetSell() {
        List<Assets> assetsList = new ArrayList<>();
        for(Long x : listIntId){
            updateStatus(x);
        }
    }

    @Override
    public List<Assets> getAssetsNew(int month, int year) {
        return assetsRepository.getAssetsNew(month,year);
    }

    @Override
    public List<Assets> getByName(String name) {
        return assetsRepository.getByName(name);
    }

    @Override
    public List<Assets> getByStatus(int status) {
        return assetsRepository.getByStatus(status);
    }

    @Override
    public List<Assets> getByDeparment(long id) {
        return assetsRepository.getByDepartmentsId(id);
    }

    @Override
    public List<Assets> getByGroupAsset(long id) {
        return assetsRepository.getByGroupId(id);
    }

    @Override
    public List<Assets> getByCateAsset(long id) {
        return assetsRepository.getByCateId(id);
    }

    @Override
    public List<Assets> sell(String listId,String price) {
        String[] listStringId = listId.split(",");
        String [] listStringPrice = price.split(",");
        List<Assets> assetsList = new ArrayList<>();
        for (String x : listStringPrice){
            if(Long.parseLong(x) != 0){
                listPrice.add(Long.parseLong(x));
            }
        }
        for (String x : listStringId) {
            listIntId.add(Long.parseLong(x));
        }
        for (int i = 0; i < listIntId.size(); i++) {
            Assets assets = findById(listIntId.get(i));
            assets.setSellPrice(listPrice.get(i));
            assetsList.add(assets);
        }
        return assetsList;
    }

    @Override
    public List<Assets> getAll() {
        return assetsRepository.getAll();
    }

    @Override
    public List<Assets> getAssetsNoRevoke() {
        return assetsRepository.getAssetsNoRevoke();
    }

    @Override
    public List<Assets> getAllWithDepart() {
        return assetsRepository.getAllWithDepart();
    }

    @Override
    public List<Assets> getAllWithStaff() {
        return assetsRepository.getAllWithStaff();
    }

    @Override
    public List<Assets> getAssetsNoUse() {
        return assetsRepository.getAssetsNoUse();
    }

    @Override
    public void create(String name, String description, int amount, String condition, int status, long price, String position, long cateId, long groupId, long suppId, int cateMoney,String uri, String url) {
        Assets assets = new Assets(name.trim(), description.trim(), amount, condition.trim(), status, price,"", cateId, groupId, suppId,0, new Date(), new Date(), cateMoney, "");
        assetsRepository.save(assets);
        Assets assets1 = assetsRepository.getLastRecord();
        assets1.setCodeAsset(createCode(assets1.getId() + ""));
//        assets1.setPathImage(makeUrl(uri,url, assets1.getId()));
        assetsRepository.save(assets1);


    }

    public  String createCode(String id){
        String strCode = "TS-";
        if(id.length() == 1 ){
            strCode =  "TS-00000" + id;
        }
        if(id.length() == 2){
            strCode =  "TS-0000" + id;
        }
        if(id.length() == 3){
            strCode =  "TS-000" + id;
        }
        if(id.length() == 4){
            strCode =  "TS-00" + id;
        }
        if(id.length() == 5){
            strCode =  "TS-0" + id;
        }
        if(id.length() == 6){
            strCode =  "TS-" + id;
        }
        return strCode;
    }

    @Override
    public Assets findById(long id) {
        return assetsRepository.findById(id).orElse(null);
    }

    @Override
    public String makeUrl(String uri, String url, long id) {
        String[] listUrl = url.split("/assets/qrcode/" + id, url.length() - 1);
        return  listUrl[0] + "/assets/detail/" + id;
    }

    @Override
    public void delete(long id) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        if (assets != null) {
            assets.setIs_deleted(1);
            assetsRepository.save(assets);
        }
    }

    @Override
    public void update(long id, AssetsView assetsView, long suppliersId, long departmentsId, long groupAssetsId, long categoryAssetsId) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        if (assets != null) {
            assets.setName(assetsView.getAssets().getName().trim());
            assets.setDescription(assetsView.getAssets().getDescription().trim());
            assets.setAmount(assetsView.getAssets().getAmount());
            assets.setConditionAsset(assetsView.getAssets().getConditionAsset().trim());
            assets.setPosition("");
            assets.setPrice(assetsView.getAssets().getPrice());
            assets.setStatus(assetsView.getAssets().getStatus());
            assets.setDepartment_id(departmentsId);
            assets.setSupplier_id(suppliersId);
            assets.setGroup_assets_id(groupAssetsId);
            assets.setAsset_category_id(categoryAssetsId);
            assets.setUpdatedDate(new Date());
            assets.setCateMoney(assetsView.getAssets().getStatus());
//            assets.setCodeAsset(assetsView.getAssets().getCodeAsset().trim());
        }
        assetsRepository.save(assets);
    }

    @Override
    public void updateTransferDepart(long id, long departmentId, Date date) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        assets.setDepartment_id(departmentId);
        assets.setUpdatedDate(date);
        assets.setStatus(1);
        assetsRepository.save(assets);
    }

    @Override
    public void updateTransferStaff(long id, long staffId, Date date) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        assets.setStaff_id(staffId);
        assets.setUpdatedDate(date);
        assets.setStatus(1);
        assetsRepository.save(assets);
    }

    @Override
    public List<Long> getListIdByName(String name) {
        return assetsRepository.getListIdByName(name);
    }


}

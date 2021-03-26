package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.service.*;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DardboardController {
    @Autowired
    private AssetsService assetsService;

    @Autowired
    private CategoryAssetsService categoryAssetsService;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private SuppliersService suppliersService;

    @Autowired
    private GroupAssetsService groupAssetsService;

    @RequestMapping("/searchAll")
    public String dardBoard(Model model, String keyWord) {
        AssetsView assets;
        if (keyWord.trim() != null && keyWord.trim() != "") {
            assets = setAssetView(new Assets());
            assets.setAssetsList(assetsService.getByName(keyWord));
            model.addAttribute("model", assets);

        } else {
            assets = setAssetView(new Assets());
            model.addAttribute("model", assets);
        }
        return "pages/assets/index";
    }

    public AssetsView setAssetView(Assets assets) {
        AssetsView assetsView = new AssetsView();
        if (assets != null) {
            assetsView.setAssets(assets);
        } else {
            assetsView.setAssets(new Assets());
        }
        assetsView.setAssetsList(assetsService.getAll());
        assetsView.setCategoryAssetsList(categoryAssetsService.getAll());
        assetsView.setDepartmentsList(departmentsService.getAll());
        assetsView.setSuppliersList(suppliersService.getAll());
        assetsView.setGroupAssetsList(groupAssetsService.getAll());
        return assetsView;
    }
}

package com.website.qlts.controller;

import com.website.qlts.dto.UserRegistrationDto;
import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Users;
import com.website.qlts.service.*;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/")
    public String home(Model model, String keyWord, String status, String categoryAssets, String groupAssets) {
        AssetsView assets;
        if (keyWord == null && status == null && categoryAssets == null && groupAssets == null) {
            assets = setAssetView(new Assets());
            model.addAttribute("model", assets);
        } else {
            if (keyWord != null && keyWord != "") {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByName(keyWord));
                model.addAttribute("model", assets);
            }
            if (!status.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByStatus(Integer.parseInt(status)));
                model.addAttribute("model", assets);
            }
            if (!categoryAssets.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByCateAsset(Integer.parseInt(categoryAssets)));
                model.addAttribute("model", assets);
            }
            if (!groupAssets.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByGroupAsset(Integer.parseInt(groupAssets)));
                model.addAttribute("model", assets);
            }
        }
        return "pages/assets/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new Users());
        return "pages/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processingLogin(Model model, @RequestParam("userName") String userName) {
        userService.loadUserByUsername(userName);
        return "pages/user/login";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage() {
        return "pages/user/logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "pages/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/register?success";
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

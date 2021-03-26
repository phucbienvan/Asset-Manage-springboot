package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.service.AssetsService;
import com.website.qlts.service.DepartmentsService;
import com.website.qlts.service.StaffService;
import com.website.qlts.service.TransferService;
import com.website.qlts.view.AssetDepartment;
import com.website.qlts.view.AssetStaff;
import com.website.qlts.view.TransferView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private   StaffService staffService;

    @Autowired
    private   DepartmentsService departmentsService;

    @Autowired
    private    TransferService transferService;

    @Autowired
    private     AssetsService assetsService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("model", assetsService.getAllWithDepart());
        return "pages/transfer-history/department-transfer";
    }

    @RequestMapping("/department")
    public String transferDepart(Model model) {
        model.addAttribute("model", assetsService.getAllWithDepart());
//        model.addAttribute("model",transferService.getAllByDepartment());
        return "pages/transfer-history/department-transfer";
    }

    @RequestMapping("/action/{id}")
    public String action(Model model, @PathVariable("id") long id) {
        TransferView transferView = new TransferView();
        transferView.setAssets(assetsService.findById(id));
        transferView.setTransferHistories(transferService.getById(id));
        transferView.setDepartmentsListOld(departmentsService.getAll());
        transferView.setDepartmentsListNew(departmentsService.getAll());
        model.addAttribute("model", transferView);
        return "pages/transfer-history/department";
    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.POST)
    public String transferWithDepart(@PathVariable("id") long id, @RequestParam("reason") String reason, @RequestParam("newDepartment") long newDepartmentId) {
        Assets assets = assetsService.findById(id);
        transferService.createAndUpdate(reason, id, assets.getDepartment_id(), newDepartmentId, assets.getUpdatedDate(), new Date(), 1);
        assetsService.updateTransferDepart(id, newDepartmentId, new Date());
        return "redirect:/transfer/department";
    }

    @RequestMapping("/staff")
    public String transferStaff(Model model) {
        model.addAttribute("model", assetsService.getAllWithStaff());
//        model.addAttribute("model",transferService.getAllByStaff());
        return "pages/transfer-history/staff-transfer";
    }

    @RequestMapping("/staff-action/{id}")
    public String staffAction(Model model, @PathVariable("id") long id) {
        TransferView transferView = new TransferView();
        transferView.setTransferHistories(transferService.getById(id));
        transferView.setStaffsListOld(staffService.getAll());
        transferView.setStaffsListNew(staffService.getAll());
        model.addAttribute("model", transferView);
        return "pages/transfer-history/staff";
    }

    @RequestMapping(value = "/staff-action/{id}", method = RequestMethod.POST)
    public String transferWithStaff(@PathVariable("id") long id, @RequestParam("reason") String reason, @RequestParam("newStaffId") long newStaffId, @RequestParam("oldStaffId") long oldStaffId) {
        Assets assets = assetsService.findById(id);
        transferService.createAndUpdate(reason, id, oldStaffId, newStaffId, assets.getUpdatedDate(), new Date(), 1);
        assetsService.updateTransferStaff(id, newStaffId, new Date());
        return "redirect:/transfer/staff";
    }

    @RequestMapping("/department/history")
    public String departHistory(Model model) {
        model.addAttribute("model", transferService.getAllByDepartment());
        return "pages/transfer-history/history-depart";
    }

    @RequestMapping("/staff/history")
    public String staffHistory(Model model) {
        model.addAttribute("model", transferService.getAllByStaff());
        return "pages/transfer-history/history-staff";
    }

    @RequestMapping("/department/create")
    public String createDepart(Model model) {
        AssetDepartment assetDepartment = new AssetDepartment();
        assetDepartment.setAssetsList(assetsService.getAssetsNoUse());
        assetDepartment.setDepartmentsList(departmentsService.getAll());
        model.addAttribute("model", assetDepartment);
        return "pages/transfer-history/create-depart";
    }

    @RequestMapping(value = "/department/create", method = RequestMethod.POST)
    public String createDepart(@RequestParam("departmentId") long departmentId, @RequestParam("assetId") long assetId) {
        assetsService.updateTransferDepart(assetId, departmentId, new Date());
        return "redirect:/transfer/department";
    }

    @RequestMapping("/staff/create")
    public String createStaff(Model model) {
        AssetStaff assetStaff = new AssetStaff();
        assetStaff.setAssetsList(assetsService.getAssetsNoUse());
        assetStaff.setStaffsList(staffService.getAll());
        model.addAttribute("model", assetStaff);
        return "pages/transfer-history/create-staff";
    }

    @RequestMapping(value = "/staff/create", method = RequestMethod.POST)
    public String createStaff(@RequestParam("staffId") long staffId, @RequestParam("assetId") long assetId) {
        assetsService.updateTransferStaff(assetId, staffId, new Date());
        return "redirect:/transfer/staff";
    }

}

package com.website.qlts.controller;

import com.website.qlts.config.FileStoragePropertiesAvatar;
import com.website.qlts.entity.Staffs;
import com.website.qlts.service.DepartmentsService;
import com.website.qlts.service.FileStorageService;
import com.website.qlts.service.StaffService;
import com.website.qlts.view.StaffDepartments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private FileStoragePropertiesAvatar storagePropertiesAvatar;
    @Autowired
    private FileStorageService storageService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<Staffs> staffsList;
        if (keyWord != null) {
            staffsList = staffService.getByName(keyWord);
        } else {
            staffsList = staffService.getAll();
        }

        model.addAttribute("staffs", staffsList);
        return "pages/staffs/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        StaffDepartments staffDepartments = new StaffDepartments();
        staffDepartments.setDepartmentsList(departmentsService.getAll());
        staffDepartments.setStaffs(new Staffs());
        model.addAttribute("staffDepartments", staffDepartments);
        return "pages/staffs/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@RequestParam("departmentsId") String departmentsId, @RequestParam("file") MultipartFile file,
                             @RequestParam("dateOfBirth") String dateOfBirth, @Valid @ModelAttribute("staffDepartments") StaffDepartments staff, BindingResult result) throws IOException {

        if (result.hasErrors()) {
            return "pages/staffs/create";
        }
        if (file.isEmpty()) {
            return "pages/staffs/create";
        } else {
            String fileName = storageService.storeFile(file);
            String fileDownloadUri = storagePropertiesAvatar.getUrl() + "/avatar/" + fileName;
            Staffs staffs = staff.getStaffs();
            staffService.create(new Staffs(staffs.getName(), convertStringToDate(dateOfBirth), staffs.getAddress(), staffs.getPhoneNumber(), 0, Long.parseLong(departmentsId), fileDownloadUri));
        }

        return "redirect:/staffs/";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        model.addAttribute("model", staffService.getById(id));
        return "pages/staffs/detail";
    }


    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        staffService.delete(id);
        return "redirect:/staffs/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Staffs> staffsList = staffService.getByName(name);
        model.addAttribute("staffs", staffsList);
        return "redirect:/staffs/";
    }

    public Date convertStringToDate(String dateString) {
        String dateStringFormat = dateString.replace('-', '/');
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(dateStringFormat);
        } catch (Exception ex) {
        }

        return date;
    }
}

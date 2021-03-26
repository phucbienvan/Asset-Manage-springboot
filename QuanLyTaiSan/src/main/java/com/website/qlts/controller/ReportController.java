package com.website.qlts.controller;

import com.website.qlts.config.ExportExcel;
import com.website.qlts.config.FileStoragePropertiesAvatar;
import com.website.qlts.entity.RevokeHistories;
import com.website.qlts.entity.TransferHistories;
import com.website.qlts.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private FileStoragePropertiesAvatar storagePropertiesAvatar;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private TransferService transferService;

    @Autowired
    private AssetsService assetsService;

    @Autowired
    private RevokeHistoryService revokeHistoryService;

//
//    @RequestMapping("/report-transfer")
//    public String indexPage(Model model, String keyWord) {
//        return "pages/report/revoke-poached";
//    }
//
//    @RequestMapping("/report-statement")
//    public String statementPage(Model model, String keyWord) {
//        return "pages/report/statement";
//    }
//
//    @RequestMapping("/report-revoke-poached")
//    public String poachedPage(Model model, String keyWord) {
//        return "pages/report/statement";
//    }
//
//    @RequestMapping("/report-revoke")
//    public String revokePage(Model model, String keyWord) {
//        return "pages/report/revoke";
//    }
//
//    @RequestMapping("/report-new")
//    public String newPage(Model model, String keyWord) {
//        return "pages/report/new";
//    }
//
//    @RequestMapping("/report-use")
//    public String usePage(Model model, String keyWord) {
//        return "pages/report/use";
//    }


    @RequestMapping("/report-statement")
    public ModelAndView reportStatement(Model model, String toDate, String fromDate, String keyWord) {
//        List<RevokeHistories> revokeHistories;
//        revokeHistories = revokeHistoryService.getAll();
//        model.addAttribute("model", revokeHistories);
        ModelAndView modelAndView = new ModelAndView("/pages/report/statement");

        model.addAttribute("model", transferService.getAll());
//        return "/pages/report/statement";
        return modelAndView;
    }

    @RequestMapping("/report-use")
    public String reportUse(Model model, String toDate, String fromDate, String keyWord) {
        if (keyWord != null && keyWord != "") {
            model.addAttribute("model", getUsedHistoryByName(keyWord));
        } else if (toDate != null && fromDate != null && toDate != "" && fromDate != "") {
            model.addAttribute("model", transferService.getByDate(fromDate, toDate));
        } else {
            model.addAttribute("model", transferService.getAll());
        }

        return "/pages/report/use";
    }

    @RequestMapping("/report-new")
    public String reportNew(Model model) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        model.addAttribute("model", assetsService.getAssetsNew(month, year));
        return "/pages/report/new";
    }

    @RequestMapping("/report-transfer")
    public String reportSTransfer(Model model, String toDate, String fromDate, String keyWord) {
        if (keyWord != null && keyWord != "") {
            model.addAttribute("model", getTransferHistoryByName(keyWord));
        } else if (toDate != null && fromDate != null && toDate != "" && fromDate != "") {
            model.addAttribute("model", transferService.getByDate(fromDate, toDate));
        } else {
            model.addAttribute("model", transferService.getAll());
        }
        return "/pages/report/transfer";
    }

    @RequestMapping("/report-revoke")
    public String reportRevoke(Model model, String toDate, String fromDate, String keyWord) {
        if (keyWord != null && keyWord != "") {
            model.addAttribute("model", getRevokeHistoryByName(keyWord));
        } else if (toDate != null && fromDate != null && toDate != "" && fromDate != "") {
            model.addAttribute("model", revokeHistoryService.getByDate(convertStringToDate(fromDate), convertStringToDate(toDate)));
        } else {
            model.addAttribute("model", revokeHistoryService.getAll());
        }
        return "/pages/report/revoke";
    }

    @RequestMapping("/searchAll")
    public String searchAll(String keyWord, Model model) {
        List<?> list = new ArrayList<>();
        if (keyWord.trim() != null && keyWord.trim() != "") {
            list = assetsService.getByName(keyWord);
            if (list != null) {
                model.addAttribute("model", list);
                return "pages/assets/index";
            } else {
                list = staffService.getByName(keyWord);
                model.addAttribute("model", list);
                return "pages/staffs/index";
            }
        }
        return "redirect:/";
    }

    @RequestMapping("/report-revoke-poached")
    public String reportRevokePoached() {
        return "/pages/report/revoke-poached";
    }

    @RequestMapping("/export-file-transfer")
    public String exportTransfer(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelTransfer(httpServletResponse, transferService.getAll());
        return "redirect:/report-transfer";
    }

    @RequestMapping("/export-file-use")
    public String exportUse(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelUse(httpServletResponse, transferService.getAll());
        return "redirect:/report-transfer";
    }

    @RequestMapping("/export-file-new")
    public String exportNew(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelNew(httpServletResponse, assetsService.getAll());
        return "redirect:/report-new";
    }

    @RequestMapping("/export-file-revoke")
    public String exportRevoke(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelRevoke(httpServletResponse, revokeHistoryService.getAll());
        return "redirect:/report-revoke";
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

    public List<Long> listId(String name) {
        return assetsService.getListIdByName(name);
    }

    public List<RevokeHistories> getRevokeHistoryByName(String name) {
        List<RevokeHistories> revokeHistories = new ArrayList<>();
        for (long i : listId(name)) {
            revokeHistories.addAll(revokeHistoryService.getById(i));
        }
        return revokeHistories;
    }

    public List<TransferHistories> getTransferHistoryByName(String name) {
        List<TransferHistories> transferHistories = new ArrayList<>();
        for (long i : listId(name)) {
            transferHistories.addAll(transferService.getListById(i));
        }
        return transferHistories;
    }

    public List<TransferHistories> getUsedHistoryByName(String name) {
        List<TransferHistories> usedHistory = new ArrayList<>();
        for (long i : listId(name)) {
            usedHistory.addAll(transferService.getListById(i));
        }
        return usedHistory;
    }
}

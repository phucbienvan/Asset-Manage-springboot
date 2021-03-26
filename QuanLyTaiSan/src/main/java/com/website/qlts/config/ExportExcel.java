package com.website.qlts.config;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.RevokeHistories;
import com.website.qlts.entity.TransferHistories;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ExportExcel {

    @Autowired
    ResourceLoader resourceLoader;

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    private static final String[] columnsNew = {"STT","Mã tài sản" ,"Tên tài sản", "Tình trạng", "Giá", "Loại tài sản", "Nhóm tài sản", "Nhà sản xuất"};
    private static final String[] columns = {"STT","Mã tài sản" , "Tên tài sản", "Lý do", "Người dùng trước", "Người dùng sau", "Thời gian từ", "Đến"};
    private static final String[] columnsUse = {"STT","Mã tài sản" , "Tên tài sản", "Chi tiết", "Người sử dụng trước", "Người sử dụng sau", "Thời gian từ", "Đến"};
    private static final String[] columnsRevoke = {"STT","Mã tài sản" , "Tên tài sản", "Phòng ban/Nhân viên", "Ghi chú", "Ngày thu hồi"};

    public void exportExcelTransfer(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columns[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getCodeAsset());
            row.createCell(2).setCellValue(emp.getAssets().getName());
            row.createCell(3).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(4).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(5).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(4).setCellValue(emp.getStaffs().getName());
                row.createCell(5).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(6);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(7);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCaoDieuChuyen" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCaoDieuChuyen" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelUse(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnsUse.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columnsUse[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getCodeAsset());
            row.createCell(2).setCellValue(emp.getAssets().getName());
            row.createCell(3).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(4).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(5).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(4).setCellValue(emp.getStaffs().getName());
                row.createCell(5).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(5);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(6);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columnsUse.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCaoLichSuSuDung" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCaoLichSuSuDung" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelNew(HttpServletResponse response, List<Assets> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<Assets> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnsNew.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columnsNew[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (Assets emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getCodeAsset());
            row.createCell(2).setCellValue(emp.getName());
            row.createCell(3).setCellValue(emp.getConditionAsset());
            row.createCell(4).setCellValue(emp.getPrice());
            row.createCell(5).setCellValue(emp.getCategoryAssets().getName());
            row.createCell(6).setCellValue(emp.getGroupAssets().getGroupName());
            row.createCell(7).setCellValue(emp.getSuppliers().getName());
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell createDate = row.createCell(8);
            createDate.setCellValue(emp.getCreateDate());
            createDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columnsNew.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCaoTaiSanMoi" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCaoTaiSanMoi" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelRevoke(HttpServletResponse response, List<RevokeHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<RevokeHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnsRevoke.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columnsRevoke[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (RevokeHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getCodeAsset());
            row.createCell(2).setCellValue(emp.getAssets().getName());
            row.createCell(3).setCellValue(emp.getReason());
            if (emp.getStaffId() == 0 ) {
                row.createCell(4).setCellValue(emp.getDepartments().getDepartmentName());
            } else {
                row.createCell(4).setCellValue(emp.getStaffs().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell revokeDate = row.createCell(5);
            revokeDate.setCellValue(emp.getRevokeDate());
            revokeDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columnsRevoke.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCaoThuHoi"  + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCaoThuHoi"  + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }
}


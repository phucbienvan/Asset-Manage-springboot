package com.website.qlts.config;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class CreateDownloadFile {
    public void download(HttpServletResponse response,String filePath) throws IOException {
        try {
            ExportExcel exportExel = new ExportExcel();
            File file = ResourceUtils.getFile(filePath);
            byte[] data = FileUtils.readFileToByteArray(file);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
            response.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

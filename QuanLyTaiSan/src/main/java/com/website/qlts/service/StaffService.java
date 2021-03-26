package com.website.qlts.service;

import com.website.qlts.entity.Staffs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {
    public Staffs create(Staffs staffs);

    public List<Staffs> getAll();

    public List<Staffs> getByName(String name);

    public Staffs getById(long id);

    public void delete(long id);

    public String uploadFile(MultipartFile multipartFile) throws IOException;
}

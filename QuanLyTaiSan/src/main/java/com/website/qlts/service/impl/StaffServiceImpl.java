package com.website.qlts.service.impl;

import com.website.qlts.entity.Staffs;
import com.website.qlts.repository.StaffRepository;
import com.website.qlts.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staffs create(Staffs staffs){
        return staffRepository.save(staffs);
    }

    @Override
    public List<Staffs> getAll() {
        return staffRepository.getAll();
    }

    @Override
    public  List<Staffs> getByName(String name){
        List<Staffs> staffsList = staffRepository.getByName(name);
        return  staffsList;
    }

    @Override
    public Staffs getById(long id) {
        return staffRepository.getById(id);
    }

    @Override
    public  void delete(long id){
        Staffs staffs = staffRepository.findById(id).orElse(null);
        staffs.setIs_deleted(1);
        staffRepository.save(staffs);
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        File directory = new File("");
        File file = new File(directory.getAbsolutePath()  + "\\src\\main\\resources\\static\\avatar\\" + multipartFile.getOriginalFilename());
        String filePath = directory.getAbsolutePath()  + "\\src\\main\\resources\\static\\avatar\\\\" + multipartFile.getOriginalFilename();
        file.createNewFile();
        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return multipartFile.getOriginalFilename();
    }

}

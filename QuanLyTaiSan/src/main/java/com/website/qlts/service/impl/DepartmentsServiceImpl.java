package com.website.qlts.service.impl;

import com.website.qlts.entity.Departments;
import com.website.qlts.repository.DepartmentsRepository;
import com.website.qlts.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    DepartmentsRepository departmentsRepository;

    @Override
    public Departments create(String name, long departmentParentId) {
        Departments departments = new Departments();
        departments.setDepartmentName(name);
        departments.setParentId(departmentParentId);
        return departmentsRepository.save(departments);
    }

    @Override
    public List<Departments> getAll() {
        List<Departments> departmentsList = new ArrayList<>();
        List<Departments> listDad = departmentsRepository.getParentId(0);

        for (Departments dad : listDad){
            departmentsList.add(dad);
            List<Departments> listChildren = departmentsRepository.getParentId(dad.getId());
            for (Departments children : listChildren){
                children.setDepartmentName("------"+children.getDepartmentName());
                departmentsList.add(children);
            }
        }
        return departmentsList;
    }

    @Override
    public Departments getById(long id) {
        return departmentsRepository.findById(id).orElse(null);
    }

    @Override
    public void update(long id, String name) {
        Departments departments = departmentsRepository.findById(id).orElse(null);
        departments.setDepartmentName(name);
        departmentsRepository.save(departments);
    }

    @Override
    public void delete(long id) {
        Departments departments = departmentsRepository.findById(id).orElse(null);
        departments.setIs_deleted(1);
        departmentsRepository.save(departments);
    }

    @Override
    public List<Departments> getByName(String name) {
        return null;
    }

    @Override
    public List<Departments> getDepartmentParentDaddy() {
        return departmentsRepository.getParentId(0);
    }
}


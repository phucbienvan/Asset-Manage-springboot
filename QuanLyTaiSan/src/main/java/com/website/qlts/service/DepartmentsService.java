package com.website.qlts.service;

import com.website.qlts.entity.Departments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentsService  {
    public Departments create(String name, long departmentParentId);

    public List<Departments> getAll();

    public Departments getById(long id);

    public void update(long id, String name);

    public void delete(long id);

    public List<Departments> getByName(String name);

    public List<Departments> getDepartmentParentDaddy();

}

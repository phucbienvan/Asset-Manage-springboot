package com.website.qlts.view;

import com.website.qlts.entity.Departments;

import java.util.List;

public class DepartmentView {
    private List<Departments> departmentsList;
    private Departments departments;

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}

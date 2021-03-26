package com.website.qlts.view;

import com.website.qlts.entity.Departments;
import com.website.qlts.entity.Staffs;

import java.util.List;

public class StaffDepartments {
    private Staffs staffs;
    private List<Departments> departmentsList;

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public StaffDepartments(Staffs staffs, List<Departments> departmentsList) {
        this.staffs = staffs;
        this.departmentsList = departmentsList;
    }
    public StaffDepartments(){
    }
}

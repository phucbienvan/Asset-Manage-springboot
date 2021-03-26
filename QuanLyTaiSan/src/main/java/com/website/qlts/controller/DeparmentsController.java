package com.website.qlts.controller;

import com.website.qlts.entity.Departments;
import com.website.qlts.service.DepartmentsService;
import com.website.qlts.view.DepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Controller
@RequestMapping("/departments")
public class DeparmentsController {

    @Autowired
    private  DepartmentsService departmentsService;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("model", departmentsService.getAll());
        return "pages/departments/index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        DepartmentView departmentView = new DepartmentView();
        departmentView.setDepartments(new Departments());
        departmentView.setDepartmentsList(departmentsService.getDepartmentParentDaddy());
        model.addAttribute("model",departmentView);
        return "pages/departments/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("departmentParentId") long departmentParentId, @Valid @ModelAttribute("model") DepartmentView departments, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "pages/departments/create";
        }
        departmentsService.create(departments.getDepartments().getDepartmentName(), departmentParentId);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("model", departmentsService.getById(id));
        return "pages/departments/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @RequestParam("departmentName") String departmentName,
                       @Valid @ModelAttribute("model") Departments departments, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "pages/departments/edit";
        }
        departmentsService.update(id, departmentName);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        departmentsService.delete(id);
        return "redirect:/departments";
    }

}

package com.website.qlts.controller;

import com.website.qlts.entity.CategoriesSuppliers;
import com.website.qlts.service.CategorySuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category-suppliers")
public class CategorySuppliersController {
    @Autowired
    private CategorySuppliersService categorySuppliersService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<CategoriesSuppliers> listAssets;
        if (keyWord != null) {
            listAssets = categorySuppliersService.getByName(keyWord);
        } else {
            listAssets = categorySuppliersService.getAll();
        }

        model.addAttribute("cate", listAssets);
        return "pages/category-suppliers/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("cate", new CategoriesSuppliers());
        return "pages/category-suppliers/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(Model model, @Valid @ModelAttribute("cate") CategoriesSuppliers categoriesSupplier, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "pages/category-suppliers/create";
        }
        model.addAttribute("cate", categoriesSupplier);
        categorySuppliersService.create(categoriesSupplier.getName());
        return "redirect:/category-suppliers/";
    }

    @RequestMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        CategoriesSuppliers assets = categorySuppliersService.getById(id);
        model.addAttribute("cate", assets);
        return "pages/category-suppliers/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String editPage(@RequestParam String name, @PathVariable("id") long id, Model model, @Valid @ModelAttribute("cate") CategoriesSuppliers categoriesSupplier, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "pages/category-suppliers/edit";
        }
        model.addAttribute("cate", categoriesSupplier);
        categorySuppliersService.update(id, name);
        return "redirect:/category-suppliers/";
    }

    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        categorySuppliersService.delete(id);
        return "redirect:/category-suppliers/";
    }
}

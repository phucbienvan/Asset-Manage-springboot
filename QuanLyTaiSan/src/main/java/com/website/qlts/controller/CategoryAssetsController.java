package com.website.qlts.controller;

import com.website.qlts.entity.CategoryAssets;
import com.website.qlts.entity.Departments;
import com.website.qlts.service.CategoryAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category-assets")
public class CategoryAssetsController {
    @Autowired
    private  CategoryAssetsService categoryAssetsService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<CategoryAssets> listAssets;
        if (keyWord != null) {
            listAssets = categoryAssetsService.getByName(keyWord);
        } else {
            listAssets = categoryAssetsService.getAll();
        }

        model.addAttribute("cate", listAssets);
        return "pages/category-assets/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("cate", new CategoryAssets());
        return "pages/category-assets/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage( Model model, @Valid @ModelAttribute("cate") CategoryAssets categoryAssets, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "pages/category-assets/create";
        }
        else{
            model.addAttribute("cate", categoryAssets);
            categoryAssetsService.create(categoryAssets.getName());
        }

        return "redirect:/category-assets/";
    }

    @RequestMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        CategoryAssets assets = categoryAssetsService.getById(id);
        model.addAttribute("cate", assets);
        return "pages/category-assets/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String editPage(@RequestParam String name, @PathVariable("id") long id, Model model,@Valid @ModelAttribute("cate") CategoryAssets categoryAssets, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "pages/category-assets/edit";
        }
        categoryAssetsService.update(id, name);
        return "redirect:/category-assets/";
    }

    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        categoryAssetsService.delete(id);
        return "redirect:/category-assets/";
    }

//    @RequestMapping("/search")
//    public String search(@RequestParam String name, Model model){
//        List<CategoryAssets> assetsList = categoryAssetsService.getByName(name);
//        model.addAttribute("cate",assetsList);
//        return "redirect:/category-assets/";
//    }
}

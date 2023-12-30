package com.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.task.models.Categories;
import com.task.repostories.CategoriesRepository;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/getAll")
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Categories getCategorieById(@PathVariable Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping("/add")
    public Categories addCategorie(@RequestBody Categories categorie) {
        return categoriesRepository.save(categorie);
    }

    @PutMapping("/update/{id}")
    public Categories updateCategorie(@PathVariable Long id, @RequestBody Categories categorie) {
        categorie.setId(id);
        return categoriesRepository.save(categorie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categoriesRepository.deleteById(id);
    }
}

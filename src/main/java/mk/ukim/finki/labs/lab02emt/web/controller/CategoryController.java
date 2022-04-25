package mk.ukim.finki.labs.lab02emt.web.controller;

import mk.ukim.finki.labs.lab02emt.model.enumerations.Category;
import mk.ukim.finki.labs.lab02emt.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }
}

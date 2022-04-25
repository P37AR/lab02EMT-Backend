package mk.ukim.finki.labs.lab02emt.service.impl;

import mk.ukim.finki.labs.lab02emt.model.enumerations.Category;
import mk.ukim.finki.labs.lab02emt.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}

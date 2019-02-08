package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.Ad;
import ru.basanov.model.Category;
import ru.basanov.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findOne(String id) {
        if (id == null || id.isEmpty()) return null;
        return categoryRepository.findOne(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void removeById(String id) {
        if(id == null || id.isEmpty()) return;
        categoryRepository.removeById(id);
    }

    public Category getCategoryById(String id) {
        return categoryRepository.getCategoryById(id);
    }

    public List<String> getListCategoryId() {
        return categoryRepository.getListCategoryId();
    }

    public List<Category> getListCategory() {
        return categoryRepository.getListCategory();
    }

    public Long getCountCategory() {
        return categoryRepository.getCountCategory();
    }

    public void removeAll() {
        categoryRepository.removeAll();
    }
}

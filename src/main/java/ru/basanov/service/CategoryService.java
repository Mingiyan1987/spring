package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.basanov.model.Category;
import ru.basanov.repository.CategoryRepository;

import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public <S extends Category> S save(S s) {
        return categoryRepository.save(s);
    }

    public <S extends Category> Iterable<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    public Optional<Category> findById(String s) {
        return categoryRepository.findById(s);
    }

    public boolean existsById(String s) {
        return categoryRepository.existsById(s);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Iterable<Category> findAllById(Iterable<String> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    public long count() {
        return categoryRepository.count();
    }

    public void deleteById(String s) {
        categoryRepository.deleteById(s);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public void deleteAll(Iterable<? extends Category> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}

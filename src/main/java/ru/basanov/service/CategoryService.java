package ru.basanov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basanov.model.Category;
import ru.basanov.repository.AbstractRepository;
import ru.basanov.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService extends AbstractRepository implements CategoryRepository{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void persist(Category category) {
        categoryRepository.persist(category);
    }

    @Override
    public void merge(Category category) {
        categoryRepository.merge(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.remove(category);
    }

    @Override
    public <S extends Category> S save(S s) {
        return categoryRepository.save(s);
    }

    @Override
    public <S extends Category> Iterable<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    @Override
    public Optional<Category> findById(String s) {
        return categoryRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return categoryRepository.existsById(s);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Iterable<Category> findAllById(Iterable<String> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void deleteById(String s) {
        categoryRepository.deleteById(s);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteAll(Iterable<? extends Category> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}

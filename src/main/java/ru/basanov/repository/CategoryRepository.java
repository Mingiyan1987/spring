package ru.basanov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

    void persist(Category category);

    void merge(Category category);

    void remove(Category category);
}

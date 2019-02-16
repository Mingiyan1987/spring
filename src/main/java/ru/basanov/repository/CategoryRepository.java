package ru.basanov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.model.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

    void persist(Category category);

    void merge(Category category);

    void remove(Category category);
}

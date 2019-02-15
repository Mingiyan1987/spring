package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.enterprise.configuration.DataSourceConfiguration;
import ru.basanov.model.Category;
import ru.basanov.service.CategoryService;


/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setNameCategory("New");
        categoryService.persist(category);
    }
}


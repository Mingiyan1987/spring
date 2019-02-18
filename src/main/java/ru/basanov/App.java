package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.configuration.DataSourceConfiguration;
import ru.basanov.model.Ad;
import ru.basanov.model.Category;
import ru.basanov.repository.AdRepository;
import ru.basanov.service.AdService;
import ru.basanov.service.CategoryService;


/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        final Ad ad = new Ad();
        final AdService adService = ctx.getBean(AdService.class);
        adService.findAll();
        ad.setContent("ifjeljsfe");
        adService.persist(ad);
    }
}


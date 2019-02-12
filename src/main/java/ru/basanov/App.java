package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.config.ApplicationConfig;
import ru.basanov.model.Ad;
import ru.basanov.repository.AdRepository;
import ru.basanov.service.AdService;


/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
}


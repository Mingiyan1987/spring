package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.api.INest;
import ru.basanov.config.ApplicationConfig;
import ru.basanov.processor.UnproducableChickenBeanFactoryPostProcessor;

/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        INest nest = context.getBean(INest.class);
        nest.feedTheChicken();
        nest.flyOutOfTheNest();
        nest.feedTheChicken();
        nest = context.getBean("nest", INest.class);
        nest.feedTheChicken();
    }
}

package ru.basanov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.basanov.config.ApplicationConfig;
import ru.basanov.model.Chicken;
import ru.basanov.model.Nest;


/*
 * @author Mingiyan Basanov
 */

public class App {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final Nest nest = context.getBean(Nest.class);
        final Chicken chicken = context.getBean(Chicken.class);
        System.out.println(nest);
        System.out.println(chicken);
        System.out.println();

        System.out.println(context.getBean("Provider", Nest.class));
        System.out.println(context.getBean("Provider"));
        System.out.println();

        System.out.println(context.getBean("Consumer", Chicken.class));
        System.out.println(context.getBean("Consumer"));
    }
}

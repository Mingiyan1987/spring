package ru.basanov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.basanov.model.Chicken;
import ru.basanov.model.Nest;

/*
 * @author Mingiyan Basanov
 */

@Configuration
public class ApplicationConfig {

    @Bean("Provider")
    public Nest nest() {
        final Nest nest = new Nest();
        nest.setName("Малое гнездо");
        return nest;
    }

    @Bean("Consumer")
    public Chicken chicken() {
        final Chicken chicken = new Chicken();
        chicken.setName("Птенчик");
        return chicken;
    }
}

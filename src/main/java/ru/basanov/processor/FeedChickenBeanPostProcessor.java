package ru.basanov.processor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.basanov.model.NestImpl;

@Component
public class FeedChickenBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof NestImpl) {
            System.out.println("Кормим птенца без гнезда");
            ((NestImpl) bean) .feedTheChicken();
            System.out.println("Птенец поел, нужно вить гнездо");
        }
        return bean;
    }
}

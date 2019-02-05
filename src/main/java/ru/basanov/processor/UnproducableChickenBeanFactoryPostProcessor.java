package ru.basanov.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.basanov.api.UnproducableChicken;

@Component
public class UnproducableChickenBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("[BeanFactoryPostProcessor]");
        System.out.println();
        for (String name: beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            System.out.println(name + " : " + className);
            try {
                final Class<?> beanClass = Class.forName(className);
                UnproducableChicken annotation = (UnproducableChicken) beanClass.getAnnotation(UnproducableChicken.class);
                System.out.println("name annotation" + annotation);
                if (annotation != null) {
                    Class eatingChickenName = annotation.feedTheChickenClass();
                    beanDefinition.setBeanClassName(eatingChickenName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

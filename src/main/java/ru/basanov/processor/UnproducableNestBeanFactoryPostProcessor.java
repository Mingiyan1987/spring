package ru.basanov.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.basanov.api.UnproducableNest;

@Component
public class UnproducableNestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory nestBeanFactory) throws BeansException {
        String[] nestBeanDefinitionNames = nestBeanFactory.getBeanDefinitionNames();
        System.out.println();
        System.out.println("[NestBeanFactoryPostProcessor]");
        for (String name: nestBeanDefinitionNames) {
            BeanDefinition beanDefinition = nestBeanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            System.out.println(name + " : " + className);
            try {
                final Class<?> beanClass = Class.forName(className);
                UnproducableNest annotation = (UnproducableNest) beanClass.getAnnotation(UnproducableNest.class);
                System.out.println("name annotation" + annotation);
                if (annotation != null) {
                    Class buildNestName = annotation.buildNestClass();
                    beanDefinition.setBeanClassName(buildNestName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

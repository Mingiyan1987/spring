package ru.basanov.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.basanov.api.IChicken;
import ru.basanov.api.INest;

import javax.annotation.PostConstruct;

@Component("nestBean")
@Scope("prototype")
public class NestBean implements INest {

    @Autowired
    @Qualifier("white")
    private IChicken chicken;

    @Value("true")
    private boolean nestlingInTheNest;

    @Override
    public IChicken getIChicken() {
        return chicken;
    }

    @Override
    public void setChicken(IChicken chicken) {
        this.nestlingInTheNest = false;
        this.chicken = chicken;
    }

    @Override
    public void feedTheChicken() {
        if (inTheNested()) {
            System.out.println("Птенец накормлен");
            this.chicken.eating();
        } else {
            System.out.println("Птенца в гнезде нет");
        }
    }

    @Override
    public void flyOutOfTheNest() {
        this.chicken = null;
        this.nestlingInTheNest = false;
    }

    @Override
    public boolean inTheNested() {
        return nestlingInTheNest;
    }

    @PostConstruct
    @Override
    public void chickWhantsToEat() {
        System.out.println("Птенец хочет есть");
    }
}

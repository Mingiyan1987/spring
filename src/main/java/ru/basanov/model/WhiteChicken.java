package ru.basanov.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.basanov.api.IChicken;
import ru.basanov.api.UnproducableChicken;

@Primary
@Component("white")
@UnproducableChicken(feedTheChickenClass = YellowChicken.class)
public class WhiteChicken implements IChicken {

    private Integer weight = 10;

    @Override
    public void eating() {
        this.weight++;
        System.out.println("Вес белого птенца = " + this.weight);
    }
}

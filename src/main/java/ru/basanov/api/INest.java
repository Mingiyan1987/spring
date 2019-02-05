package ru.basanov.api;



public interface INest {

    IChicken getIChicken();

    void setChicken(IChicken ichicken);

    void feedTheChicken();

    void flyOutOfTheNest();

    boolean inTheNested();

    public void chickWhantsToEat();
}

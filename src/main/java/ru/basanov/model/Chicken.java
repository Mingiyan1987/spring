package ru.basanov.model;

/*
 * @author Mingiyan Basanov
 */

public class Chicken {

    private String name;

    public Chicken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chicken() {

    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                '}';
    }
}

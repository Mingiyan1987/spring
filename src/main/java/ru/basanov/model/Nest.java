package ru.basanov.model;

/*
 * @author Mingiyan Basanov
 */

public class Nest {

    private String name;

    public Nest(String name) {
        this.name = name;
    }

    public Nest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nest{" +
                "name='" + name + '\'' +
                '}';
    }
}

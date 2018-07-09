package com.sda.hotnews.category;

public class Category {

    private static int counter = 0;

    private int id;
    private String name;

    public Category(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }
}


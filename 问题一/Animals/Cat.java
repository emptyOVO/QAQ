package com.Animals;

import java.util.StringJoiner;

public class Cat extends Animal{

    public Cat(String name, Integer age, Character sex) {
        super(name, age, sex);
    }
    public Cat(){}
    public Cat(String name, Integer age, Character sex, Double price) {
        super(name, age, sex, price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
                .add("Name='" + Name + "'")
                .add("Age=" + Age)
                .add("Sex=" + Sex)
                .add("Price=" + Price)
                .toString();
    }


    public boolean equals(Cat obj) {
        return super.equals(obj);
    }
}

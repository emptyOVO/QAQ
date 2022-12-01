package com.Animals;

import java.util.StringJoiner;

public class China_Dog extends Animal {
    public China_Dog(){
    }
    public China_Dog(String name, Integer age, Character sex, Double price) {
        super(name, age, sex, price);
    }
    public China_Dog(String name, Integer age, Character sex) {
        super(name, age, sex);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", China_Dog.class.getSimpleName() + "[", "]")
                .add("Name='" + Name + "'")
                .add("Age=" + Age)
                .add("Sex=" + Sex)
                .add("Price=" + Price)
                .toString();
    }


    public boolean equals(China_Dog obj) {
        return super.equals(obj);
    }
}

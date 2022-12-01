package com.Animals;


import java.util.Objects;
import java.util.StringJoiner;

public abstract class Animal {
    protected String Name;
    protected Integer Age;
    protected Character Sex;
    protected Double Price;

    public Animal(String name, Integer age, Character sex) {
        Name = name;
        Age = age;
        Sex = sex;
    }

    public Animal(String name, Integer age, Character sex, Double price) {
        Name = name;
        Age = age;
        Sex = sex;
        Price = price;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Animal.class.getSimpleName() + "[", "]")
                .add("Name='" + Name + "'")
                .add("Age=" + Age)
                .add("Sex=" + Sex)
                .add("Price=" + Price)
                .toString();
    }


    public boolean equals(Animal o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(Name, ((Animal) o).Name) && Objects.equals(Age, ((Animal) o).Age) && Objects.equals(Sex, ((Animal) o).Sex);
    }


}

package com.java;

public class Tortoise extends Animal{
    private String turtleShell;
    public int age = 100;



    public void exchangeAge() {
        System.out.println(this.age);
        this.age = super.age;
        System.out.println(this.age);
    }

    public static void main(String[] args) {
        System.out.println(master);
        Tortoise tortoise = new Tortoise();
        tortoise.exchangeAge();
        Animal animal = new Animal();
        System.out.println(animal);
    }
}

package com.java;

public class Animal {
    public String name;
    public int age = 10;
    public String color;
    public int hasFoot;

    public static String master="gee";

    {
        this.age=99;
        this.hasFoot = 2;
    }
    @Override
    public String toString() {
        return "Tortoise{" +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", hasFoot=" + hasFoot +
                '}';
    }
}

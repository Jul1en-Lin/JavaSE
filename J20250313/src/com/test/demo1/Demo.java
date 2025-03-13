package com.test.demo1;

public class Demo {
    public int cpu;
    public int screen;
    private int number;//封装 只能在当前类使用
    int brand;

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBrand(int i) {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "cpu=" + this.cpu +
                ", screen=" + this.screen +
                ", number=" + this.number +
                ", brand=" + this.brand +
                '}';
        //可自行修改
    }
}

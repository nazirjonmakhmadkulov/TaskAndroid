package com.nazirjon.taskandroid.model;

public class Bun {
    String name;
    int count;
    String time;
    double price;

    public Bun(String name, int count, String time, double price) {
        this.name = name;
        this.count = count;
        this.time = time;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

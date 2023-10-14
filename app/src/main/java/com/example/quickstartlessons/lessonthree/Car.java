package com.example.quickstartlessons.lessonthree;

public class Car implements EngineStartListener {
    private String name;
    private int year;
    private Engine engine;

    public Car(String name, int year, Engine engine) {
        this.name = name;
        this.year = year;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("car is driving");
    }

    @Override
    public void onEngineStarted() {
        System.out.println("vbsdjbh");
    }
}

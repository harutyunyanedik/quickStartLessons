package com.example.quickstartlessons.kotlin.lessonfour;

public class Developer extends Person {
    private String name;
    private Integer age;
    private Boolean gender;

    public Developer(String name) {
        this(name, 0, true);
    }

    @Override
    public void printName() {
        System.out.println("Developer");
    }

    public Developer(String name, int age, boolean gander) {
        this.name = name;
        this.age = age;
        this.gender = gander;

        // something
    }

    public void printElements() {
        // name , age, gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals("valod"))  {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}

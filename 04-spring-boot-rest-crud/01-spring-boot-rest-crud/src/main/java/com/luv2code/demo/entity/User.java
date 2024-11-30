package com.luv2code.demo.entity;

public class User {
    public User(int age, String name, String school) {
        this.age = age;
        this.name = name;
        this.school = school;
    }

    int age;
    String name;
    String school;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

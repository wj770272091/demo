package com.example.demo.bean;

import javax.validation.constraints.Size;

/**
 * @NAME: Person
 * @USER: 77027
 * @DATE: 2021/1/4
 * @TIME: 16:30
 */
public class Person {
    @Size(max = 4,min = 2)
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String nation;
    private String address;
}

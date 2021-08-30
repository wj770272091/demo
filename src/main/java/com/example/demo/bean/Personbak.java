//package com.example.demo.bean;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import java.util.Objects;
//
///**
// * @NAME: Person
// * @USER: 77027
// * @DATE: 2020/10/12
// * @TIME: 14:00
// */
//@Entity
//@NamedQuery(name = "Person.withNameAndAddressNameQuery", query = "select p from Person p where p.name=?1 and p.address=?2")
//public class Person {
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String name;
//    private Integer age;
//    private String address;
//    public Person(){
//        super();
//    }
//    public Person(Long id,String name,Integer age,String address){
//        super();
//        this.id=id;
//        this.name=name;
//        this.age=age;
//        this.address=address;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//}

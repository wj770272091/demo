//package com.example.demo.bean;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.LinkedHashSet;
//
///**
// * @NAME: Person
// * @USER: 77027
// * @DATE: 2020/10/12
// * @TIME: 14:00
// */
//@Document
//
//public class PersonMongo {
//    @Id
//    private String id;
//    private String name;
//    private Integer age;
//    @Field("locs")
//    private Collection<Location> locations =new LinkedHashSet<Location>();
//    public PersonMongo(String name, Integer age){
//        super();
//        this.name=name;
//        this.age=age;
//
//    }
//    public Collection<Location> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(Collection<Location> locations) {
//        this.locations = locations;
//    }
//
//
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
//
//}

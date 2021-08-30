package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @NAME: Location
 * @USER: 77027
 * @DATE: 2020/12/30
 * @TIME: 14:33
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Location {
    private String place;
    private String year;
    public Location(String place,String year){
        super();
        this.place=place;
        this.year=year;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

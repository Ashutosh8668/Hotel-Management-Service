package com.example.hotel.HotelService.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//our flow is user class=> repository =>services => serviceimpl => resourceexceptionhandler=>controller=> globalexceptionhandler 
//@Getter//@Setter//@NoArgsConstructor//@AllArgsConstructor we can use them as well to avoid constructor or getter setter
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

    // Default constructor (no-args)
    public Hotel() {
    }

    // Parameterized constructor
    public Hotel(String id, String name, String location, String about) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAbout() {
        return about;
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
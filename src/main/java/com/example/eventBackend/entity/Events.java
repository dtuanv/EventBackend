package com.example.eventBackend.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String date;
    String location;
    String description;
    String image;
    String category;

    public Events(String name, String date, String location, String description, String image, String category) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
        this.image = image;
        this.category= category;
    }


}

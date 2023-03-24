package com.example.eventBackend.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Events {
    @Id
    int id;
    String name;
    String date;
    String location;
    String comment;
}

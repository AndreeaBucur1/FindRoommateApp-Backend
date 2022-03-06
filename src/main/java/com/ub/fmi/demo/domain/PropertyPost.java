package com.ub.fmi.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="rental")
public class PropertyPost {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String title;

    @Column
    String propertyType;

    @Column
    Integer numberOfRooms;

    @Column
    Integer numberOfBathrooms;

    @Column
    Integer Floor;

    @Column
    Integer surface;

    @Column
    Boolean hasParkingSpot;

    @Column
    Boolean hasElevator;

    @Column
    Integer buildYear;

    @Column
    Integer price;

    @Column
    String description;


}

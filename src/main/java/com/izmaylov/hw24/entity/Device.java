package com.izmaylov.hw24.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id", nullable = false)
    private long id;
    @Column
    private String type;
    @Column
    private String model;
    @Column
    private int price;
    @Column
    private Date dateOfCreation;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private boolean available;
    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Device(String type, String model, int price, Date dateOfCreation, String description, boolean available, Factory factory) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.available = available;
        this.factory = factory;
    }
}

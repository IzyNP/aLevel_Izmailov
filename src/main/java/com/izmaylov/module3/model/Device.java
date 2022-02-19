package com.izmaylov.module3.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private int id;

    @Column(name = "device_name")
    String name;

    Device(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.izmaylov.hw23.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@Getter
@Setter
@ToString
public class FactoryDevice {
    private long id;
    private String type;
    private String model;
    private int price;
    private Date dateOfCreation;
    private String description;
    private boolean available;
    private long factoryId;
    private String name;
    private String country;
}

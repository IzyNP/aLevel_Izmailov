package com.izmaylov.hw18.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class Box {
    private String from;
    private String material;
    private String color;
    private MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
    private Cargo cargo = new Cargo();
    private LocalDateTime deliveryDate;
}

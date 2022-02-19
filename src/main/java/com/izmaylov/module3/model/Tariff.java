package com.izmaylov.module3.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Entity
@Table(name = "tariffs")
@NoArgsConstructor
public abstract class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    private int id;

    @Column(name = "price")
    private int price;

    public Tariff(int price) {
        this.price = price;
    }
}

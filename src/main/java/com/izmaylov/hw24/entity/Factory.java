package com.izmaylov.hw24.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "factories")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "FactoryIdGenerator")
    @Column(name = "factory_id",nullable = false)
    private long id;
    @Column
    private String name;
    @Column
    private String country;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }
}

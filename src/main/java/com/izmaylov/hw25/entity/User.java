package com.izmaylov.hw25.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column
    private String userName;
    @Column
    private Date dateOfBirth;

    public User(String userName, Date dateOfBirth) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("Nikita", Date.valueOf("1995-08-22")));
        users.add(new User("Maxim",Date.valueOf("1994-08-22")));
        users.add(new User("Jack", Date.valueOf("2005-12-31")));
        return users;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

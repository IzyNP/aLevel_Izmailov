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
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private MovieSession movieSession;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private Date dateOfPurchase;
    @Column
    private int seat;

    public Ticket(MovieSession movieSession, User user, Date dateOfPurchase, int seat) {
        this.movieSession = movieSession;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
    }

    public static List<Ticket> getTickets(List<MovieSession> movieSessions, List<User> users){
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(movieSessions.get(0), users.get(0),Date.valueOf("2022-10-25"),5));
        tickets.add(new Ticket(movieSessions.get(1), users.get(1),Date.valueOf("2022-12-31"),6));
        tickets.add(new Ticket(movieSessions.get(2), users.get(2),Date.valueOf("2020-05-24"),33));
        tickets.add(new Ticket(movieSessions.get(2), users.get(2),Date.valueOf("2020-05-24"),34));
        return tickets;
    }
}

package com.izmaylov.hw25.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sessions")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_hall_id")
    private long id;
    @Column(name = "cinema_hall")
    private int numberOfCinemaHall;
    @Column
    private int numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public MovieSession(int numberOfCinemaHall, int numberOfSeats, Movie movie) {
        this.numberOfCinemaHall = numberOfCinemaHall;
        this.numberOfSeats = numberOfSeats;
        this.movie = movie;
    }

    public static List<MovieSession> getMovieSessions(List<Movie> movies){
        List<MovieSession> movieSessions = new ArrayList<>();

        movieSessions.add(new MovieSession(15,1, movies.get(0)));
        movieSessions.add(new MovieSession(15,2, movies.get(1)));
        movieSessions.add(new MovieSession(15,3, movies.get(2)));

        return movieSessions;
    }
}

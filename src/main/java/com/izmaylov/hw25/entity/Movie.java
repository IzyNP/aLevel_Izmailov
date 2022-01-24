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
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;
    @Column
    private String movieName;
    @Column
    private Date dateOfCreation;

    public Movie(String movieName, Date dateOfCreation) {
        this.movieName = movieName;
        this.dateOfCreation = dateOfCreation;
    }

    public static List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toy Story",Date.valueOf("1995-11-22")));
        movies.add(new Movie("Toy Story 2",Date.valueOf("1999-11-13")));
        movies.add(new Movie("Toy Story 3",Date.valueOf("2000-02-10")));
        return movies;
    }
}

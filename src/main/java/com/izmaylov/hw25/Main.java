package com.izmaylov.hw25;

import com.izmaylov.hw25.entity.Movie;
import com.izmaylov.hw25.entity.MovieSession;
import com.izmaylov.hw25.entity.Ticket;
import com.izmaylov.hw25.entity.User;
import com.izmaylov.hw25.repository.DatabaseRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.getUsers();
        List<Movie> movies = Movie.getMovies();
        List<MovieSession> movieSessions = MovieSession.getMovieSessions(movies);
        List<Ticket> tickets = Ticket.getTickets(movieSessions, users);
        DatabaseRepository databaseRepository = new DatabaseRepository();

        users.forEach(databaseRepository::addUser);
        movies.forEach(databaseRepository::addMovie);
        movieSessions.forEach(databaseRepository::addMovieSession);
        tickets.forEach(databaseRepository::addTicket);

        databaseRepository.getAllMovieSessions().forEach(System.out::println);
        databaseRepository.getAllUsers().forEach(System.out::println);
        databaseRepository.getMovieByContains("2").forEach(System.out::println);
        databaseRepository.getAllTicketByUser(3).forEach(System.out::println);

        Ticket ticket = tickets.get(3);

        databaseRepository.deleteTicket(ticket);

    }
}

package com.izmaylov.hw25.repository;

import com.izmaylov.hw25.entity.Movie;
import com.izmaylov.hw25.entity.MovieSession;
import com.izmaylov.hw25.entity.Ticket;
import com.izmaylov.hw25.entity.User;
import com.izmaylov.hw24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private Transaction transaction;

    public void addUser(User user) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void addMovie(Movie movie){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public void addMovieSession(MovieSession movieSession){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public void addTicket(Ticket ticket){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void deleteTicket(Ticket ticket){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public List<MovieSession> getAllMovieSessions(){
        List<MovieSession> movieSessions = new ArrayList<>();
        try(Session session  = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> query = session.createQuery("from MovieSession");
            transaction = session.beginTransaction();
            movieSessions = query.getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return movieSessions;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(Session session  = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("from User");
            transaction = session.beginTransaction();
            users = query.getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return users;
    }

    public List<Movie> getMovieByContainsString(String string){
        string = "%" + string + "%";
        List<Movie> movies = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("from Movie WHERE movieName LIKE :movieName", Movie.class);
            query.setParameter("movieName",string );
            transaction = session.beginTransaction();
            movies = query.getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return movies;
    }


    public List<Ticket> getAllTicketByUserId(long id){
        List<Ticket> tickets = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("from Ticket WHERE user_id =:user_id", Ticket.class);
            query.setParameter("user_id",id);
            transaction = session.beginTransaction();
            tickets = query.getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return tickets;
    }
}

package com.izmaylov.module3.services;

import com.izmaylov.hw24.util.HibernateUtil;
import com.izmaylov.module3.entity.Message;
import com.izmaylov.module3.entity.Subscriber;
import com.izmaylov.module3.model.Device;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    Transaction transaction;

    public Subscriber getSubscriberWithMostSentMessages() {
        Subscriber subscriber = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Subscriber> query = session.createQuery("FROM Subscriber as subscriber WHERE subscriber.countOfMessage = (" +
                    "select max(s.countOfMessage) from Subscriber s)", Subscriber.class);
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            subscriber = query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return subscriber;
    }

    public Subscriber getSubscriberWhoDidMostCalls() {
        Subscriber subscriber = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Subscriber> query = session.createQuery("FROM Subscriber as subscriber WHERE subscriber.countOfCalls = (" +
                    "select max(s.countOfCalls) from Subscriber s)", Subscriber.class);
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            subscriber = query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return subscriber;
    }

    public Subscriber getSubscriberWhoMostFrequentlySurfInternet() {
        Subscriber subscriber = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Subscriber> query = session.createQuery("FROM Subscriber as subscriber WHERE subscriber.countOfInternetSurfing = (" +
                    "select max(s.countOfInternetSurfing) from Subscriber s)", Subscriber.class);
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            subscriber = query.getSingleResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return subscriber;
    }

    public List<Subscriber> getTopFiveSubscribersByActivity() {
        List<Subscriber> subscribers = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Subscriber ORDER BY (count_of_messages + count_of_calls + count_of_internet_surfing) DESC");
            query.setMaxResults(5);
            transaction = session.beginTransaction();
            subscribers = query.getResultList();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return subscribers;
    }

    public List<Message> getMessageByConcreteWord(String string) {
        string = '%' + string + '%';
        List<Message> messages = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Message> query = session.createQuery("from Message WHERE text LIKE :text", Message.class);
            query.setParameter("text", string);
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            messages = query.getResultList();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return messages;
    }

    public Device whichDeviceIsMostPopular() {
        Device device = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Device> query = session.createQuery("FROM Device WHERE id IN (SELECT s.deviceId FROM Subscriber s GROUP BY s.deviceId ORDER BY count(s.deviceId) DESC)", Device.class);
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            device = query.getSingleResult();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return device;
    }

    public void whichServiceMostPopular() {
        long calls = allCalls();
        long messages = allMessages();
        long surfings = allSurfings();

        if(calls >  messages && calls > surfings){
            System.out.println("Calling is most popular service");
        }else if(messages > calls && messages > surfings){
            System.out.println("Messaging is most popular service");
        }else{
            System.out.println("Internet is most popular service");
        }
    }

    private long allMessages() {
        Long count = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT sum(s.countOfMessage) FROM Subscriber s");
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            count = query.getSingleResult();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return count;
    }


    private long allCalls() {
        Long count = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT sum(s.countOfCalls) FROM Subscriber s");
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            count = query.getSingleResult();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return count;
    }

    private long allSurfings() {
        Long count = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT sum(s.countOfInternetSurfing) FROM Subscriber s");
            query.setMaxResults(1);
            transaction = session.beginTransaction();
            count = query.getSingleResult();
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return count;
    }
}

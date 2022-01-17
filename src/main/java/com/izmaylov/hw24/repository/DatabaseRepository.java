package com.izmaylov.hw24.repository;

import com.izmaylov.hw24.entity.Device;
import com.izmaylov.hw24.entity.Factory;
import com.izmaylov.hw24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private Transaction transaction = null;

    public void addFactory(Factory factory) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(factory);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addDevice(Device device) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(device);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Factory getFactoryById(long id) {
        Factory factory = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Factory> query = session.createQuery("from Factory where id = :factoryId", Factory.class);
            query.setParameter("factoryId", id);
            factory = query.getSingleResult();
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public Device getDeviceById(long id) {
        Device device = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Device> query = session.createQuery("from Device where id = :deviceId", Device.class);
            query.setParameter("deviceId", id);
            device = query.getSingleResult();
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device;
    }

    public void updateDevice(Device device) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            device.setAvailable(false);
            transaction = session.beginTransaction();
            session.update(device);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDevice(Device device) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(device);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Device>  getAllDevicesFromFactory(long id) {
        List<Device> resultList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Device> query = session.createQuery("from Device as device inner join fetch device.factory where device.factory.id = :factoryId");
            query.setParameter("factoryId", id);
            resultList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return resultList;
    }



    public void getAllDevicesAndSumForFactory(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List query = session.createQuery("select device.factory.id, count (device.id), sum(device.price) from Device as device group by device.factory.id order by device.factory.id").list();
            transaction.commit();
            for (Object o : query) {
                Object[] device = (Object[]) o;
                System.out.println("Factory " + device[0] + " made " + device[1] + " device(s) in the amount of " + device[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

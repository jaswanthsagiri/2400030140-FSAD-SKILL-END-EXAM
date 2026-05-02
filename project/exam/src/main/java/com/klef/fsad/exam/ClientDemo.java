package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Vehicle v1 = new Vehicle();
        v1.setName("Tesla Model X");
        v1.setDescription("Electric SUV");
        v1.setDate(new Date());
        v1.setStatus("Available");
        session.save(v1);

        Vehicle v2 = session.get(Vehicle.class, 1); // assuming ID=1 exists
        if(v2 != null) {
            v2.setName("Tesla Model Y");
            v2.setStatus("Sold");
            session.update(v2);
        }

        tx.commit();
        session.close();
        factory.close();
    }
}

package org.example.fullrowing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;

public class ConectionDB {
    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory(){


        org.jboss.logging.Logger logger =
                org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate")
                .setLevel(Level.SEVERE);
        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        if (session != null) {
            System.out.println("Session successfully opened!");
        }
        else
        {
            System.out.println("Error opening session!");
        }

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        return createSessionFactory();
    }
}

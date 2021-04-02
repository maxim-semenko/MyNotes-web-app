package com.max.project.util;

import com.max.project.entity.Note;
import com.max.project.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j2
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Note.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                log.fatal("Fatal to get SessionFactory: " + e);
            }
        }
        return sessionFactory;
    }
}
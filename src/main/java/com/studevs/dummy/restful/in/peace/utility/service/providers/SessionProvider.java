package com.studevs.dummy.restful.in.peace.utility.service.providers;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ashik
 */
public class SessionProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Single session factory instance for the application.
     */
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private Session session;

    /**
     * This method will provide Session object per call.
     *
     * @return
     */
    public Session getSession() {
        return session;
    }

    /**
     * This init method will be initialized in SessionProvider bean creation.
     */
    public void initSession() {

        this.session = SESSION_FACTORY.openSession();
    }

    /**
     * This method will destroy session object while destroying SessionProvider bean
     */
    public void destroySession() {

        this.session.close();
    }
}

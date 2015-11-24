package lastSeen.DataBase.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory       sessionFactory        = null;
    private static ThreadLocal<Session> session               = new ThreadLocal<Session>();
    private static Configuration        configuration         = null;
    public static final String          SESSION_ERROR_MESSAGE = "couldn't open session to hibernate";
    public static final String          DBObject_NOT_VALID    = "Not valid DBObject data[values]";

    private static SessionFactory buildSessionFactory() {
        try {
            if (configuration != null) {
                // using spacial configuration
                sessionFactory = configuration.buildSessionFactory();
                return sessionFactory;
            }
            // Create the SessionFactory from hibernate.cfg.xml
            // new Configuration().
            // using default configuration according to cfg file.
            return new Configuration().configure().buildSessionFactory();
        } catch (final Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getCurrentSession() {
        Session s = null;
        s = session.get();
        try {
            // sessionFactory = new
            // Configuration().configure().buildSessionFactory();
            if (s == null) {
                System.out.println("opening session");
                s = sessionFactory.openSession();
                session.set(s);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public static Session getSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (final HibernateException e) {
            try {
                session = HibernateUtil.getCurrentSession();
                if (!session.isOpen()) {
                    session = sessionFactory.openSession();
                }
            } catch (final Exception ex) {
                System.out.println("Couldn't get lastSeen.DataBase.hibernate session ");
            }
        }
        return session;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public static <T> java.util.List<T> listFrom(final Criteria criteria) {
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public static <T> java.util.List<T> listFrom(final Query query) {
        return query.list();
    }

}

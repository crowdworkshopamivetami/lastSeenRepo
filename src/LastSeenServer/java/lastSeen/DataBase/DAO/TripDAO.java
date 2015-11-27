package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.MissingPerson;
import lastSeen.DataBase.dbObjects.Sighting;
import lastSeen.DataBase.dbObjects.Trip;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Barak on 24/11/2015.
 */
public class TripDAO {

    private static String FIND_ALL = "Trip.findAll";

    public static List<Trip> findAll() {
        System.out.println(TripDAO.class + ": finaAll : Start");
        List<Trip> trips;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery("MissingPerson.findAll");
            trips = HibernateUtil.listFrom(query);

        } catch (final RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
            transaction.rollback();
            throw e;
        } finally {
            try {
                session.flush();
                session.close();
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(TripDAO.class + ": finaAll : End");
        return trips;
    }


    public static void update(final Trip tripEntry) {
        System.out.println(TripDAO.class + ": update : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.update(tripEntry);
            session.flush();
            transaction.commit();
        } catch (final RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
            transaction.rollback();
            throw e;
        } finally {
            try {
                session.close();
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(TripDAO.class + ": update : End");
    }

    public static void add(final Trip tripEntry) {
        System.out.println(TripDAO.class + ": add : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.save(tripEntry);
            session.flush();
            transaction.commit();
        } catch (final RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
            transaction.rollback();
            throw e;
        } finally {
            try {
                session.close();
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(TripDAO.class + ": add : End");
    }

    public static boolean delete(final Trip tripEntry) {
        System.out.println(TripDAO.class + ": delete : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Boolean isDeleted;
        try {
            session.delete(tripEntry);
            session.flush();
            transaction.commit();
        } catch (final RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
            transaction.rollback();
            throw e;
        } finally {
            try {
                session.close();
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
        isDeleted = true;
        System.out.println(TripDAO.class + ": delete : End (" + isDeleted + ")");
        return isDeleted;
    }
}




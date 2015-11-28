package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.MissingPerson;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Barak on 24/11/2015.
 */
public class MissingPersonDAO {

    private static String FIND_ALL = "MissingPerson.findAll";

    public static List<MissingPerson> findAll() {
        System.out.println(MissingPersonDAO.class + ": finaAll : Start");
        List<MissingPerson> missingPersons;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery("MissingPerson.findAll");
            missingPersons = HibernateUtil.listFrom(query);

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
        System.out.println(MissingPersonDAO.class + ": finaAll : End");
        return missingPersons;
    }


    public static void update(final MissingPerson missingPersonEntry) {
        System.out.println(MissingPersonDAO.class + ": update : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.update(missingPersonEntry);
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
        System.out.println(MissingPersonDAO.class + ": update : End");
    }

    public static void add(final MissingPerson missingPersonEntry) {
        System.out.println(MissingPersonDAO.class + ": add : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.save(missingPersonEntry);
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
        System.out.println(MissingPersonDAO.class + ": add : End");
    }

    public static boolean delete(final MissingPerson missingPersonEntry) {
        System.out.println(MissingPersonDAO.class + ": delete : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Boolean isDeleted;
        try {
            session.delete(missingPersonEntry);
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
        System.out.println(MissingPersonDAO.class + ": delete : End (" + isDeleted + ")");
        return isDeleted;
    }
}




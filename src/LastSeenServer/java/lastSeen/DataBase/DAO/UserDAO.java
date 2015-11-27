package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.User;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Created by AmirSk on 11/27/2015.
 */

public class UserDAO {

    private static String FIND_ALL = "User.findAll";

    public static List<User> findAll() {
        System.out.println(UserDAO.class + ": findAll : Start");
        List<User> users;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery("User.findAll");
            users = HibernateUtil.listFrom(query);

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
        System.out.println(UserDAO.class + ": finaAll : End");
        return users;
    }

    public static void update(final User userEntry){
        System.out.println(UserDAO.class + ": update : Start");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(userEntry);
            session.flush();
            transaction.commit();
        }
        catch (final RuntimeException e) {
            System.err.println("RuntimeException: " + e.getMessage());
            transaction.rollback();
            throw e;
        }
        finally {
            try {
                session.close();
            } catch (final Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.println(UserDAO.class + ": update : End");

    }

    public static void add(final User userEntry) {
        System.out.println(UserDAO.class + ": add : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.save(userEntry);
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
        System.out.println(UserDAO.class + ": add : End");
    }

    public static boolean delete(final User userEntry) {
        System.out.println(UserDAO.class + ": delete : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Boolean isDeleted;
        try {
            session.delete(userEntry);
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
        System.out.println(UserDAO.class + ": delete : End (" + isDeleted + ")");
        return isDeleted;
    }
}
package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.CheckIn;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by yoavsusan on 11/27/2015.
 */
public class CheckInDAO {

    private static String FIND_ALL = "CheckIn.findAll";

    public static List<CheckIn> findAll() {
        System.out.println(CheckInDAO.class + ": finaAll : Start");
        List<CheckIn> checkIns;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery(FIND_ALL);
            checkIns = HibernateUtil.listFrom(query);

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
        System.out.println(CheckInDAO.class + ": finaAll : End");
        return checkIns;
    }

    public static void update(final CheckIn checkInEntry) {
        System.out.println(CheckInDAO.class + ": update : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.update(checkInEntry);
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
        System.out.println(CheckInDAO.class + ": update : End");
    }

    public static void add(final CheckIn checkInEntry) {
        System.out.println(CheckInDAO.class + ": add : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            session.save(checkInEntry);
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
        System.out.println(CheckInDAO.class + ": add : End");
    }

    public static boolean delete(final CheckIn checkInEntry) {
        System.out.println(CheckInDAO.class + ": delete : Start");
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Boolean isDeleted;
        try {
            session.delete(checkInEntry);
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
        System.out.println(CheckInDAO.class + ": delete : End (" + isDeleted + ")");
        return isDeleted;
    }
}

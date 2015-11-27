package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.Contact;
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
    private static String findAll = "User.findAll";

    public static List<User> findAll() {
        System.out.println(ContactDAO.class + ": findAll : Start");
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



}





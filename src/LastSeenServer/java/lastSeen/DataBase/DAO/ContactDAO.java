package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.Contact;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by kabessa on 21/11/2015.
 */
public class ContactDAO {

    private static String findAll = "Contact.findAll";

    public static List<Contact> findAll() {
        System.out.println(ContactDAO.class + ": finaAll : Start");
        List<Contact> contacts;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery("Contact.findAll");
            contacts = HibernateUtil.listFrom(query);

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
        System.out.println(ContactDAO.class + ": finaAll : End");
        return contacts;
    }
}

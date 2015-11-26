package lastSeen.DataBase.DAO;

import lastSeen.DataBase.dbObjects.Sighting;
import lastSeen.DataBase.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by yoavsusan on 21/11/2015.
 */
public class SightingDAO {

    private static String findAll = "Sighting.findAll";

    public static List<Sighting> findAll() {
        System.out.println(SightingDAO.class + ": finaAll : Start");
        List<Sighting> sightings;
        Session session;
        Transaction transaction;
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        try {
            Query query;
            query = session.getNamedQuery(findAll);
            sightings = HibernateUtil.listFrom(query);

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
        System.out.println(SightingDAO.class + ": finaAll : End");
        return sightings;
    }
}

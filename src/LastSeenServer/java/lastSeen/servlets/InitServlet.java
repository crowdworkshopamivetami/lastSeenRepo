package lastSeen.servlets;

import lastSeen.DataBase.DAO.ContactDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by kabessa on 14/11/2015.
 */
public class InitServlet implements ServletContextListener {

    @Override
    public void contextDestroyed(final ServletContextEvent servletContextEvent) {
    }


    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {

        initDBConnection();
        System.out.print("Last Seen Server initialized.");
    }

    private void initDBConnection() {
        // ADD A SMALL DB QUERY
    }
}

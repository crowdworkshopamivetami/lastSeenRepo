package lastSeen.servlets;

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

        System.out.print("Last Seen Server initialized.");
    }
}

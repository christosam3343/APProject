package server;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {

    private static SessionFactory factory = null;

    public static SessionFactory buildSessionFactory() {
        if (factory == null) {
            try {
                Configuration config = new Configuration();
                File configFile = new File("resources/hibernate.cfg.xml");
                config.configure(configFile);
                factory = config.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    public static void closeSessionFactory() {
        if (factory != null && !factory.isClosed()) {
            factory.close();
        }
    }
}

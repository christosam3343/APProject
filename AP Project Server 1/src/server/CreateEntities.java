package server;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import generalinfo.Staff;

public class CreateEntities {
	private final static Logger logger = LogManager.getLogger(CreateEntities.class);
    
    private static Session session;

    public static void saveStaff(Staff staff) {
        Transaction trans = null;
        try {
            session = GetSessionFactory.buildSessionFactory().openSession();
            trans = session.beginTransaction();
            session.save(staff);
            trans.commit();
        } catch (RuntimeException e) {
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
            logger.error("Error: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

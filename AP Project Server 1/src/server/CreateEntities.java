package server;

import org.hibernate.Session;
import org.hibernate.Transaction;

import generalinfo.Staff;

public class CreateEntities {
    
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
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

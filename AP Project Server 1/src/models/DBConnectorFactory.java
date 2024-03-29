package models;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBConnectorFactory {
	private final Logger logger = LogManager.getLogger(DBConnectorFactory.class);
//    private static final Logger logger = LogManager.getLogger(DBConnectorFactory.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection dbConn;

    // method for getting database connection
    public static void getDatabaseConnection() {
        try {
            if (dbConn == null) {
                dbConn = DriverManager.getConnection(URL + "jhtdatabase", USER, PASS);
            }
            LocalDateTime localDateTime = LocalDateTime.now();
//            logger.info("DB Connection Established @ " + localDateTime.format(dateTimeFormatter));
        } catch (SQLException e) {
//            logger.warn("SQLException: " + e.getMessage());
            boolean isYes;
            int selection = JOptionPane.showConfirmDialog(
                    null,
                    "Could not connect to database jhtdatabase." +
                            "\n" + e.getMessage() +
                            "\nRetry?",
                    "Connection Failure",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE
            );
            isYes = (selection == JOptionPane.YES_OPTION);
            if (isYes) {
//                createjhtDatabase();
                getDatabaseConnection();
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
//            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
}

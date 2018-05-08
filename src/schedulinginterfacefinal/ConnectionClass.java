/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrewwarner
 */
public class ConnectionClass {
    static private final String URL = "jdbc:derby://localhost:1527/FlightSchedulerDBAndrewWarneracw5456";
    static private final String USERNAME = "java";
    static private final String PASSWORD = "java";
    static private Connection connection;
    
    
    static public Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
                
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
    
    static public void close() {
        try
        {
            connection.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    
}
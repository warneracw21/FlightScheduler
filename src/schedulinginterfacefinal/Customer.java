/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author andrewwarner
 */
public class Customer {
    private String name;
    
    static private PreparedStatement getAllCustomers;
    static private PreparedStatement addNewCustomer;
    static private PreparedStatement getCustomerList;
    static private PreparedStatement clear;
    
    static {
        try {
            Connection connection = ConnectionClass.getConnection();
            getAllCustomers = connection.prepareStatement("SELECT DISTINCT * FROM Customers");
            addNewCustomer = connection.prepareStatement("INSERT INTO Customers (Name) VALUES (?)");
            getCustomerList = connection.prepareStatement("SELECT * FROM Customers WHERE Name = ?");
            clear = connection.prepareStatement("DELETE FROM Customers");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }   
    }
   
    public Customer(String name) {
        setName(name);
    }
 
    /*
    Setters
    */
    public void setName(String name) {
        this.name = name;
    }
    
    /*
    Getters
    */
    public String getName() {
        return this.name;
    }
    
    /*
    SQL Queries
    */
    static public List< Customer > getAllCustomers() {
        List< Customer > results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = getAllCustomers.executeQuery();
            results = new ArrayList< Customer >();
            
            while (resultSet.next()) {
                results.add( new Customer(resultSet.getString("Name")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                ConnectionClass.close();
            }
        }
        
        Collections.sort(results, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        
        return results;
    }
     
    static public List< Customer > getCustomerList(String name) {
        List< Customer > results = null;
        ResultSet resultSet = null;
        
        try {
            getCustomerList.setString(1, name);
            
            resultSet = getCustomerList.executeQuery();
            results = new ArrayList< Customer >();
            
            while (resultSet.next()) {
                
                results.add(new Customer(resultSet.getString("NAME")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                ConnectionClass.close();
            }
        }
        return results;
    }
    
    static public int addCustomer(String name) {
        if (name == "") {
            return 0;
        }
        System.out.println(String.format("Added Customer %s", name));
        int result = 0;
        
        try {
            addNewCustomer.setString(1, name);
            result = addNewCustomer.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            ConnectionClass.close();
        }
        return result;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    static public void clear() {
        try {
            clear.execute();
        }
        catch (SQLException sqlException) {
            ConnectionClass.close();
        }
    }
    
}

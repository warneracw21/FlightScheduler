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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author andrewwarner
 */
public class Waitlist {
    private String flight;
    private String day;
    private String customer;
    private Timestamp position;
    
    static private PreparedStatement getWaitlist;
    static private PreparedStatement addWaitlist;
    static private PreparedStatement getStatus;
    static private PreparedStatement clear;
    static private PreparedStatement cancelWaitlist;
    static private PreparedStatement getWaitlistForFlightAndDay;
    static private PreparedStatement getWaitlistByNameAndDay;
    static private PreparedStatement dropByFlight;
    
    static {
        try {
            Connection connection = ConnectionClass.getConnection();
            getWaitlist = connection.prepareStatement("SELECT * FROM Waitlist");
            addWaitlist = connection.prepareStatement("INSERT INTO Waitlist (Name, Flight, Day, Position) VALUES (?, ?, ?, ?)");
            getStatus = connection.prepareStatement("SELECT * FROM Waitlist WHERE Day = ?");
            clear = connection.prepareStatement("DELETE FROM Waitlist");
            cancelWaitlist = connection.prepareStatement("DELETE FROM Waitlist WHERE Name = ? and Day = ?");
            getWaitlistForFlightAndDay = connection.prepareStatement("SELECT * FROM Waitlist WHERE Flight = ? and Day = ?");
            dropByFlight = connection.prepareStatement("DELETE FROM Waitlist WHERE Flight = ?");
            getWaitlistByNameAndDay = connection.prepareStatement("SELECT * FROM Waitlist WHERE Name = ?");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }        
    }
    
    public Waitlist(String flight, String day, String customer, Timestamp position) {
        setFlight(flight);
        setDay(day);
        setCustomer(customer);
        setPosition(position);
    }
    
    /*
    Setters
    */
    public void setFlight(String flight) {
        this.flight = flight;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public void setPosition(Timestamp position) {
        this.position = position;
    }
    
    /*
    Getters
    */
    public String getFlight() {
        return this.flight;
    }
    public String getDay() {
        return this.day;
    }
    public String getCustomer() {
        return this.customer;
    }
    public Timestamp getPosition() {
        return this.position;
    }
    
    /*
    SQL Queries
    */
    static public List< Waitlist > getWaitlistByNameAndDay(String name) {
        System.out.println(String.format("Checking Waitlist by Name %s", name));
        List< Waitlist > results = null;
        ResultSet resultSet = null;
        
        try {
            getWaitlistByNameAndDay.setString(1, name);
            
            resultSet = getWaitlistByNameAndDay.executeQuery();
            results = new ArrayList< Waitlist >();
            
            while (resultSet.next()) {
                results.add(new Waitlist(resultSet.getString("Flight"),
                                    resultSet.getString("Day"),
                                    resultSet.getString("Name"),
                                    resultSet.getTimestamp("Position")));
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
        for (Waitlist waitlist: results) {
            System.out.println(waitlist.toString());
        }
        return results;
    }

    static public List< Waitlist > getWaitlist() {
        List< Waitlist > results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = getWaitlist.executeQuery();
            results = new ArrayList< Waitlist >();
            
            while (resultSet.next()) {
                results.add(new Waitlist(resultSet.getString("Flight"),
                                    resultSet.getString("Day"),
                                    resultSet.getString("Name"),
                                    resultSet.getTimestamp("Position")));
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
    
    
    
    static public List< Waitlist > getStatus(String day) {
        System.out.println(String.format("Checking Waitlist Status on Day %s", day));
        List < Waitlist > results = null;
        ResultSet resultSet = null;
        
        try {
            getStatus.setString(1, day);
            
            resultSet = getStatus.executeQuery();
            results = new ArrayList< Waitlist >();
            
            while (resultSet.next()) {
                results.add(new Waitlist(
                    resultSet.getString("Flight"),
                    resultSet.getString("Day"),
                    resultSet.getString("Name"),
                    resultSet.getTimestamp("Position")));
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
        
        Collections.sort(results, new Comparator<Waitlist>() {
            @Override
            public int compare(Waitlist o1, Waitlist o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        
        return results;
    }
    
        static public List< Waitlist > getWaitlistByFlightAndDay(String flightName, String day) {
        System.out.println(String.format("Checking Waitlist Status on Day %s", day));
        List < Waitlist > results = null;
        ResultSet resultSet = null;
        
        try {
            getWaitlistForFlightAndDay.setString(1, flightName);
            getWaitlistForFlightAndDay.setString(1, day);

            resultSet = getWaitlistForFlightAndDay.executeQuery();
            results = new ArrayList< Waitlist >();
            
            while (resultSet.next()) {
                results.add(new Waitlist(
                    resultSet.getString("Flight"),
                    resultSet.getString("Day"),
                    resultSet.getString("Name"),
                    resultSet.getTimestamp("Position")));
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
        
        Collections.sort(results, new Comparator<Waitlist>() {
            @Override
            public int compare(Waitlist o1, Waitlist o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        
        return results;
    }
    
    
    
    static public int addWaitlist(String flight, String day, String customer, Timestamp position) {
        System.out.println(String.format("Waitlisted %s for Flight %s on Day %s", customer, flight, day));
        int result = 0;
        
        try {
            addWaitlist.setString(1, customer);
            addWaitlist.setString(2, flight);
            addWaitlist.setString(3, day);
            addWaitlist.setTimestamp(4, position);
            
            result = addWaitlist.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            ConnectionClass.close();
        }
        
        return result;
    }
    
    static public int cancelWaitlist(String name, String day) {
        int result = 0;
        try {
            cancelWaitlist.setString(1, name);
            cancelWaitlist.setString(2, day);
            
            result = cancelWaitlist.executeUpdate();
            System.out.println("Cancelled Waitlist");
        } catch (SQLException sqlException) {
            ConnectionClass.close();
        }
        
        return result;
    }
    
    static public int dropByFlight(String flightName) {
        int result = 0;
        try {
            dropByFlight.setString(1, flightName);
            result = dropByFlight.executeUpdate();
        } catch (SQLException sqlException) {
            ConnectionClass.close();
        }
        return result;
    }
    
    @Override
    public String toString() {
        String out = String.format("Customer %s is on the waitlist for Flight %s on Day %s (Timestamp: %s", this.customer,this.flight, this.day, this.position);
        return out;
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

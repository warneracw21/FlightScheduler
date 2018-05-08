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
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author andrewwarner
 */
public class Booking {
    
    private String flight;
    private String day;
    private String customer;
    private Timestamp position;
    
    static private PreparedStatement getAllBookings;
    static private PreparedStatement addBooking;
    static private PreparedStatement getStatus;
    static private PreparedStatement getSeatCount;
    static private PreparedStatement clear;
    static private PreparedStatement cancelBooking;
    static private PreparedStatement getBookingsByflight;
    static private PreparedStatement cancelBookingByflight;
    static private PreparedStatement getBookingByNameAndDay;
    
    static {
        try {
            Connection connection = ConnectionClass.getConnection();
            getAllBookings = connection.prepareStatement("SELECT * FROM Bookings");
            addBooking = connection.prepareStatement("INSERT INTO Bookings (Name, Flight, Day, Position) VALUES (?, ?, ?, ?)");
            getStatus = connection.prepareStatement("SElECT * FROM Bookings WHERE Day = ? and Flight = ?");
            getSeatCount = connection.prepareStatement("SELECT COUNT(Flight) FROM Bookings WHERE Day = ? AND Flight = ?");
            clear = connection.prepareStatement("DELETE FROM Bookings");
            cancelBooking = connection.prepareStatement("DELETE FROM Bookings WHERE Name = ? and Day = ?");
            getBookingByNameAndDay = connection.prepareStatement("SELECT * FROM Bookings WHERE Name = ?");
            getBookingsByflight = connection.prepareStatement("SELECT * FROM Bookings WHERE Flight = ?");
            cancelBookingByflight = connection.prepareStatement("DELETE FROM Bookings WHERE Flight = ?");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }       
    }
    
    public Booking(String flight, String day, String customer, Timestamp position) {
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
    static public List< Booking > getAllBookings() {
        List< Booking > results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = getAllBookings.executeQuery();
            results = new ArrayList< Booking >();
            
            while (resultSet.next()) {
                results.add(new Booking(resultSet.getString("Flight"),
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
    
    static public List< Booking > getStatus(String flight, String day) {
        System.out.println(String.format("Checking Booking Status for Flight %s on Day %s", flight, day));
        List< Booking > results = null;
        ResultSet resultSet = null;
        
        try {
            getStatus.setString(1, day);
            getStatus.setString(2, flight);
            
            resultSet = getStatus.executeQuery();
            results = new ArrayList< Booking >();
            
            while (resultSet.next()) {
                results.add(new Booking(resultSet.getString("Flight"),
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
                ConnectionClass.close();
            }
        }
        
        Collections.sort(results, new Comparator< Booking >() {
            @Override
            public int compare(Booking o1, Booking o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        
        return results;
    }
    
    static public List< Booking > getBookingsByNameAndDay(String name) {
        System.out.println(String.format("Checking Bookings by Name %s", name));
        List< Booking > results = null;
        ResultSet resultSet = null;
        
        try {
            getBookingByNameAndDay.setString(1, name);
            
            resultSet = getBookingByNameAndDay.executeQuery();
            results = new ArrayList< Booking >();
            
            while (resultSet.next()) {
                results.add(new Booking(resultSet.getString("Flight"),
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
                ConnectionClass.close();
            }
        }
        
        Collections.sort(results, new Comparator< Booking >() {
            @Override
            public int compare(Booking o1, Booking o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        
        for (Booking booking: results) {
            System.out.println(booking.toString());
        }
        
        return results;
    }

    static public List< Booking > getBookingsByFlight(String flight) {
        List< Booking > results = null;
        ResultSet resultSet = null;
        
        try {
            getBookingsByflight.setString(1, flight);
            
            resultSet = getBookingsByflight.executeQuery();
            results = new ArrayList< Booking >();
            
            while (resultSet.next()) {
                results.add(new Booking(resultSet.getString("Flight"),
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
                ConnectionClass.close();
            }
        }
        
        Collections.sort(results, new Comparator< Booking >() {
            @Override
            public int compare(Booking o1, Booking o2) {
                return o1.getPosition().compareTo(o2.getPosition());
            }
        });
        
        return results;
    }
    
    static public int cancelBookingByFlight(String flightName) {
        int result = 0;
        try {
            cancelBookingByflight.setString(1, flightName);
            result = cancelBookingByflight.executeUpdate();
            
        } catch(SQLException sqlException) {
            ConnectionClass.close();
        }
        return result;
    }
    
    
    
    static public int addBooking(String flight, String day, String customerName) {
        System.out.println("Executing a Booking");
        int result = 0;
        Timestamp position = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        if (!toBookOrNotToBook(flight, day)) {
            result = Waitlist.addWaitlist(flight, day, customerName, position);
        }
        else {
            System.out.println(String.format("Booked %s for Flight %s on Day %s", customerName, flight, day));
            try {
                addBooking.setString(1, customerName);
                addBooking.setString(2, flight);
                addBooking.setString(3, day);
                addBooking.setTimestamp(4, position);

                result = addBooking.executeUpdate();
            }
            catch (SQLException sqlException) {
                ConnectionClass.close();
            }
        }
        
        return result;
    }
    
    static public int cancelBooking(String name, String day) {
        int result = 0;
        try {
            cancelBooking.setString(1, name);
            cancelBooking.setString(2, day);
            
            result = cancelBooking.executeUpdate();
            
            Waitlist.cancelWaitlist(name, day);
            
            List< Waitlist > waitlistEntries = Waitlist.getStatus(day);
            
            for (Waitlist waitlist: waitlistEntries) {
                System.out.println(waitlist.toString());
                if (toBookOrNotToBook(waitlist.getFlight(), day)) {
                    
                        Waitlist.cancelWaitlist(waitlist.getCustomer(), day);
                        addBooking(waitlist.getFlight(), day, waitlist.getCustomer());
                    
                }
            }
            
            System.out.println("Cancelled Booking");
        } catch (SQLException sqlException) {
            ConnectionClass.close();
        }
        
        return result;
        
    }
    
    
    /*
    Logic Methods
    */
    static public boolean toBookOrNotToBook(String flightName, String day) {
        System.out.println("Checking Whether or Not To Book");
        int seatsBooked = getStatus(flightName, day).size();
        int capacity = Flight.getFlightCapacity(flightName);
        
        return seatsBooked < capacity;
    }
    
    
    
    @Override
    public String toString() {
        String out = String.format("Customer %s is booked on Flight %s on Day %s (Timestamp: %s", this.customer,this.flight, this.day, this.position);
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

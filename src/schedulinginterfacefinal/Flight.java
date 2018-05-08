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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author andrewwarner
 */

// Flight class
public class Flight {
  
    private String flight;
    private int capacity;
    
    static private PreparedStatement getAllFlights;
    static private PreparedStatement addFlight;
    static private PreparedStatement getFlightList;
    static private PreparedStatement clear;
    static private PreparedStatement dropFlight;
    
    static {
        try {
            Connection connection = ConnectionClass.getConnection();
            getAllFlights = connection.prepareStatement("SELECT DISTINCT * FROM Flights");
            addFlight = connection.prepareStatement("INSERT INTO Flights (Flight, Capacity) " + "VALUES (?, ?)");
            getFlightList = connection.prepareStatement("SELECT * FROM Flights WHERE Flight = ?");
            clear = connection.prepareStatement("DELETE FROM Flights");
            dropFlight = connection.prepareStatement("DELETE FROM Flights WHERE Flight = ?");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } 
    }
    
    public Flight(String flight, int capacity) {
        setFlight(flight);
        setCapacity(capacity);
    }
    
    /*
    Setters
    */
    public void setFlight(String flight) {
        this.flight = flight;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
    /*
    Getters
    */
    public String getFlight() {
        return this.flight;
    }
    public int getCapacity() {
        return this.capacity;
    }
    
    /*
    SQL Queries
    */
     static public List< Flight > getAllFlights() {
        List< Flight > results = null;
        ResultSet resultSet = null;
        
        try {
            resultSet = getAllFlights.executeQuery();
            results = new ArrayList< Flight >();
            
            while (resultSet.next()) {
                
                results.add(new Flight(resultSet.getString("Flight"), 
                                       resultSet.getInt("Capacity")));
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
     
    static public List< Flight > getFlightList(String flight) {
        List< Flight > results = null;
        ResultSet resultSet = null;
        
        try {
            getFlightList.setString(1, flight);
            
            resultSet = getFlightList.executeQuery();
            results = new ArrayList< Flight >();
            
            while (resultSet.next()) {
                results.add(new Flight(
                                resultSet.getString("Flight"),
                                resultSet.getInt("Capacity")));
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
    
    static public int getFlightCapacity(String flightName) {
        int capacity = 0;
        List< Flight > flights = getFlightList(flightName);
        for (Flight flight: flights) {
            capacity = flight.getCapacity();
        }
        return capacity;
    }
    
    static public int addFlight(String flightNumber, int capacity) {
        int result = 0;
        
        try {
            addFlight.setString(1, flightNumber);
            addFlight.setInt(2, capacity);
            
            result = addFlight.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            ConnectionClass.close();
        }
        
        return result;
    }
    
    static public int dropFlight(String flightName) {
        int result = 0;
        try {
            dropFlight.setString(1, flightName);
            result = dropFlight.executeUpdate();
            Waitlist.dropByFlight(flightName);
            List< Booking > cancelledBookings = Booking.getBookingsByFlight(flightName);
            for (Booking booking: cancelledBookings) {
                boolean noBreak = true;
                Booking.cancelBookingByFlight(flightName);
                for (Flight flight: getAllFlights()) {
                    if (Booking.toBookOrNotToBook(flight.toString(), booking.getDay())) {
                        Booking.addBooking(flight.toString(), booking.getDay(), booking.getCustomer());
                        noBreak = false;
                        break;
                    }
                } if (noBreak) {
                    JOptionPane.showMessageDialog(new JFrame("Error"), String.format("Unabel to Rebook Passenger %s", (booking.getCustomer())));
                }
            }
        } catch (SQLException sqlException) {
            ConnectionClass.close();
        }
        return result;
    }
    
    @Override
    public String toString() {
        return this.flight;
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
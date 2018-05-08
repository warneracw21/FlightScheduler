/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author andrewwarner
 */
public class DataPanel extends JPanel {
    JPanel dataTablePanel;
    JTable dataTable;
    
    String currentMode;
    String dayQuery;
    String flightQuery;
    String customerQuery;
    
    
    public DataPanel() {
        setLayout( new FlowLayout() );
        dataTablePanel = setUpDataTablePanel();
        add( dataTablePanel );
        currentMode = "All";
    }
    
    public DefaultTableModel setUpAllBookingsAndWaitlist() {
        java.util.List< Booking > bookings = Booking.getAllBookings();
        java.util.List< Waitlist > waitlist = Waitlist.getWaitlist();
        String[] columnNames = {"Status", "Name", "Flight", "Day", "Position"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {   
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;
            }   
        };
        
        int i = 1;
        for (Booking booking: bookings) {
            model.addRow(new String[] {"Booked", booking.getCustomer(), booking.getFlight(), booking.getDay(), "x"});
            System.out.println(booking.toString());
            i++;
        }
        i = 1;
        for (Waitlist waitlistEntry: waitlist) {
            model.addRow(new String[] {"Waitlist", waitlistEntry.getCustomer(), waitlistEntry.getFlight(), waitlistEntry.getDay(), waitlistEntry.getPosition().toString().split("\\s")[1].split("\\.")[0]});
            System.out.println(waitlistEntry.toString());
            i++;
        }
        
        return model;
    }
    
    public DefaultTableModel setUpAllWaitlist(String day) {
        java.util.List< Waitlist > waitlist = Waitlist.getStatus(day);
        String[] columnNames = {"Status", "Name", "Flight", "Day", "Position"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;
            }
        };
        
        int i = 1;
        for (Waitlist waitlistEntry: waitlist) {
            model.addRow(new String[] {"Waitlist", waitlistEntry.getCustomer(), waitlistEntry.getFlight(), waitlistEntry.getDay(), waitlistEntry.getPosition().toString().split("\\s")[1].split("\\.")[0]});
            System.out.println(waitlistEntry.toString());
            i++;
        }
                
        return model;
    }
    
    public DefaultTableModel setUpAllBookings(String flight, String day) {
        java.util.List< Booking > bookings = Booking.getStatus(flight, day);
        String[] columnNames = {"Status", "Name", "Flight", "Day", "Position"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {       
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;
            }  
        };
        
        int i = 1;
        for (Booking booking: bookings) {
            model.addRow(new String[] {"Booked", booking.getCustomer(), booking.getFlight(), booking.getDay(), "x"});
            System.out.println(booking.toString());
            i++;
        }
        
        return model;
    }
    
    public DefaultTableModel setUpCustomer(String customerName) {
        java.util.List< Booking > bookings = Booking.getBookingsByNameAndDay(customerName);
        java.util.List< Waitlist > waitlist = Waitlist.getWaitlistByNameAndDay(customerName);
        String[] columnNames = {"Status", "Name", "Flight", "Day", "Position"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {       
            @Override
            public boolean isCellEditable(int row, int column) {                
                return false;
            }  
        };
        
        int i = 1;
        for (Booking booking: bookings) {
            model.addRow(new String[] {"Booked", booking.getCustomer(), booking.getFlight(), booking.getDay(), "x"});
            System.out.println(booking.toString());
            i++;
        }
        i = 1;
        for (Waitlist waitlistEntry: waitlist) {
            model.addRow(new String[] {"Waitlist", waitlistEntry.getCustomer(), waitlistEntry.getFlight(), waitlistEntry.getDay(), waitlistEntry.getPosition().toString().split("\\s")[1].split("\\.")[0]});
            System.out.println(waitlistEntry.toString());
            i++;
        }
        
        return model;
    }
    
    public JPanel setUpDataTablePanel() {
        setBackground(Color.decode("#F2EEE2"));
        dataTablePanel = new JPanel( new BorderLayout() );
          
        dataTable = new JTable(setUpAllBookingsAndWaitlist());
        dataTablePanel.add( new JScrollPane(dataTable) );
        dataTablePanel.setPreferredSize( new Dimension(400, 200) );
        
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = dataTable.getColumnModel().getColumn(i);
            if (i == 4) {
                column.setPreferredWidth(100); //sport column is bigger
            } else {
                column.setPreferredWidth(75);
            }
        }
        
        return dataTablePanel;
    }
    
    public void setCurrentMode(String mode) {
        this.currentMode = mode;
    }
    public void setDayQuery(String query) {
        this.dayQuery = query;
    }
    public void setFlightQuery(String query) {
        this.flightQuery = query;
    }
    public void setCustomerQuery(String query) {
        this.customerQuery = query;
    }
    
    public void updateView() {
        switch (currentMode) {
            case "All": 
                dataTable.setModel(setUpAllBookingsAndWaitlist());
                break;
            case "WAITLIST":
                dataTable.setModel(setUpAllWaitlist(dayQuery));
                break;
            case "FLIGHT":
                dataTable.setModel(setUpAllBookings(flightQuery, dayQuery));
                break;
            case "CUSTOMER":
                dataTable.setModel(setUpCustomer(customerQuery));
                break;   
        }
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = dataTable.getColumnModel().getColumn(i);
            if (i == 4) {
                column.setPreferredWidth(100); //Position column is bigger
            } else {
                column.setPreferredWidth(75);
            }
        }
    }
    
}

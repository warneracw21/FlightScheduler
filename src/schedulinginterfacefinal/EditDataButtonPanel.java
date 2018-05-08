/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class EditDataButtonPanel extends JPanel {
    private JButton editCustomers;
    private JButton editBookings;
    private JButton editFlights;
    private JButton editDays;
    
    public EditDataButtonPanel() {
        setBackground(Color.decode("#F2EEE2"));
        setLayout( new GridLayout(4,1) );
        editCustomers = new JButton("Edit Customers");
        editBookings = new JButton("Edit Bookings");
        editFlights = new JButton("Edit Flights");
        editDays = new JButton("Edit Days");
        
        add(editCustomers);
        add(editBookings);
        add(editFlights);
        add(editDays);
    }

    public JButton getEditCustomers() {
        return editCustomers;
    }

    public JButton getEditBookings() {
        return editBookings;
    }

    public JButton getEditFlights() {
        return editFlights;
    }

    public JButton getEditDays() {
        return editDays;
    }
    
    
}

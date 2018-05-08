/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class AddBookingView extends JPanel {
    private JLabel addBookingLabel;
    private JLabel customerLabel;
    private JLabel flightLabel;
    private JLabel dayLabel;
    private CustomerComboBox customerComboBox;
    private FlightComboBox flightComboBox;
    private DayComboBox dayComboBox;
    private JButton execute;
    
    public AddBookingView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        addBookingLabel = new JLabel("Add New Booking");
        addBookingLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        addBookingLabel.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(addBookingLabel,c);
        
        customerLabel = new JLabel("Customer ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(customerLabel,c);
        
        customerComboBox = new CustomerComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(customerComboBox,c);
        
        flightLabel = new JLabel("Flight ");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        add(flightLabel,c);
        flightComboBox = new FlightComboBox();
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        add(flightComboBox,c);
        
        dayLabel = new JLabel("Day ");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 1;
        add(dayLabel,c);
        dayComboBox = new DayComboBox();
        c.gridx = 1; c.gridy = 3; c.gridwidth = 1;
        add(dayComboBox,c);
        
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        add(execute,c);
        

        
        
                
        
        
    }

    public JLabel getAddBookingLabel() {
        return addBookingLabel;
    }

    public JLabel getCustomerLabel() {
        return customerLabel;
    }

    public JLabel getFlightLabel() {
        return flightLabel;
    }

    public JLabel getDayLabel() {
        return dayLabel;
    }

    public CustomerComboBox getCustomerComboBox() {
        return customerComboBox;
    }

    public FlightComboBox getFlightComboBox() {
        return flightComboBox;
    }

    public DayComboBox getDayComboBox() {
        return dayComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getCustomerComboBox().updateComboBox();
        getFlightComboBox().updateComboBox();
        getDayComboBox().updateComboBox();
        
        
    }
    
}

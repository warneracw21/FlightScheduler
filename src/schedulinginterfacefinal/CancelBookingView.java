/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class CancelBookingView extends JPanel {
    private JLabel cancelBookingLabel;
    private JLabel customerLabel;
    private CustomerComboBox customerComboBox;
    private JLabel dayLabel;
    private DayComboBox dayComboBox;
    private JButton execute;
    
    public CancelBookingView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        cancelBookingLabel = new JLabel("Cancel Booking");
        cancelBookingLabel.setHorizontalAlignment(JLabel.CENTER);
        cancelBookingLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(cancelBookingLabel, c);
        customerLabel = new JLabel("Customer ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(customerLabel, c);
        customerComboBox = new CustomerComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(customerComboBox, c);
        dayLabel = new JLabel("Day ");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        add(dayLabel, c);
        dayComboBox = new DayComboBox();
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        add(dayComboBox, c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(execute, c);
        
    }

    public JLabel getCancelBookingLabel() {
        return cancelBookingLabel;
    }

    public CustomerComboBox getCustomerComboBox() {
        return customerComboBox;
    }

    public DayComboBox getDayComboBox() {
        return dayComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getCustomerComboBox().updateComboBox();
        getDayComboBox().updateComboBox();
        
    }
    
    
    
}

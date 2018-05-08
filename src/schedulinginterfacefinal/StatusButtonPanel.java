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
public class StatusButtonPanel extends JPanel {
    private JButton viewAllBookingsAndWaitlist;
    private JButton checkCustomer;
    private JButton checkFlight;
    private JButton checkWaitlist;
    
    public StatusButtonPanel() {
        setBackground(Color.decode("#F2EEE2"));
        setLayout( new GridLayout(4,1) );
        viewAllBookingsAndWaitlist = new JButton("View All Status");
        checkCustomer = new JButton("Check Customer Status");
        checkFlight = new JButton("Check Flight Status");
        checkWaitlist = new JButton("Check Waitlist Status");
        
        add(viewAllBookingsAndWaitlist);
        add(checkCustomer);
        add(checkFlight);
        add(checkWaitlist);
    }

    public JButton getCheckCustomer() {
        return checkCustomer;
    }

    public JButton getCheckFlight() {
        return checkFlight;
    }

    public JButton getCheckWaitlist() {
        return checkWaitlist;
    }
    
    public JButton getViewAllBookingsAndWaitlist() {
        return this.viewAllBookingsAndWaitlist;
    }
    
    
}

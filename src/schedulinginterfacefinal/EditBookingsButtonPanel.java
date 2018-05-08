/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class EditBookingsButtonPanel extends JPanel {
    private JButton addBooking;
    private JButton cancelBooking;
    
    public EditBookingsButtonPanel() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridLayout(1,2) );
        addBooking = new JButton("Add Booking");
        cancelBooking = new JButton("Cancel Booking");
        
        add(addBooking);
        add(cancelBooking);
    }

    public JButton getAddBooking() {
        return addBooking;
    }

    public JButton getCancelBooking() {
        return cancelBooking;
    }
    
}

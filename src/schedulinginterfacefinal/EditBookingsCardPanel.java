/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class EditBookingsCardPanel extends CardPanel {
    private AddBookingView addBookingView;
    private CancelBookingView cancelBookingView;
    
    public EditBookingsCardPanel() {
        super();
        setBackground(Color.decode("#F5F5F5"));
        
        addBookingView = new AddBookingView();
        cancelBookingView = new CancelBookingView();
        
        add(addBookingView, "addBooking");
        add(cancelBookingView, "cancelBooking");
    }

    public AddBookingView getAddBookingView() {
        return addBookingView;
    }

    public CancelBookingView getCancelBookingView() {
        return cancelBookingView;
    }
    
}

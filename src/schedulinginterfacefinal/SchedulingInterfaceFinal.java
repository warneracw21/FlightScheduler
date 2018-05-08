/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import javax.swing.JFrame;

/**
 *
 * @author andrewwarner
 */
public class SchedulingInterfaceFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Flight.clear();
        Customer.clear();
        Booking.clear();
        Waitlist.clear();
        Day.clear();
        
        View view = new View();
        Controller controller = new Controller(view);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize( 260, 180 );
        view.setVisible( true );
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author andrewwarner
 */
public class FlightComboBox extends JComboBox {
    
    public FlightComboBox() {
        List<Flight> flights = Flight.getAllFlights();
        if (flights.isEmpty()) {
            addItem("");
        } else {
            flights.forEach((customer) -> {addItem(customer.toString());}); 
        }
    }
    
    public void updateComboBox() {
        removeAllItems();
        Flight.getAllFlights().forEach((flight) -> { addItem(flight.toString()); });
    }
    
}

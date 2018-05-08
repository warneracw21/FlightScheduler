/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class EditDataCardPanel extends CardPanel {
    private AddCustomerView editCustomersView;
    private AddDayView editDaysView;
    private EditBookingsView editBookingsView;
    private EditFlightsView editFlightsView;
    
    public EditDataCardPanel() {
        super();
        
        editCustomersView = new AddCustomerView();
        editDaysView = new AddDayView();
        editBookingsView = new EditBookingsView();
        editFlightsView = new EditFlightsView();

        add(editCustomersView, "editCustomers");
        add(editDaysView, "editDays");
        add(editBookingsView, "editBookings");
        add(editFlightsView, "editFlights");
    }

    public AddCustomerView getEditCustomersView() {
        return editCustomersView;
    }

    public AddDayView getEditDaysView() {
        return editDaysView;
    }

    public EditBookingsView getEditBookingsView() {
        return editBookingsView;
    }

    public EditFlightsView getEditFlightsView() {
        return editFlightsView;
    }
}

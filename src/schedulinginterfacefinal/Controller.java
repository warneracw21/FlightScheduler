/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.event.ActionEvent;

/**
 *
 * @author andrewwarner
 */
public class Controller {
    private View view;
    
    private EditDataCardPanel editDataAttributes;
    private AddCustomerView addCustomerAttributes;
    private AddDayView addDayAttributes;
    private EditBookingsCardPanel editBookingsAttributes;
    private AddBookingView addBookingAttributes;
    private CancelBookingView cancelBookingAttributes;
    private EditFlightsCardPanel editFlightsAttributes;
    private AddFlightView addFlightAttributes;
    private CancelFlightView cancelFlightAttributes;
    private StatusCardPanel checkStatusAttributes;
    private CheckCustomerStatus checkCustomerAttributes;
    private CheckFlightStatus checkFlightAttributes;
    private CheckWaitlistStatus checkWaitlistAttributes;
    
    private EditDataButtonPanel editDataButtonPanelAttributes;
    private StatusButtonPanel checkStatusButtonPanelAttributes;
    
    private EditBookingsButtonPanel editBookingsButtonPanelAttributes;
    private EditFlightsButtonPanel editFlightsButtonPanelAttributes;
    
    private ButtonOptionsPanel buttonOptionsPanel;
    private InterfacePanel interfacePanel;
    private DataPanel dataPanel;
    
    public Controller(View view) {
        this.view = view;
        
        editDataAttributes = view.getInterfacePanel().getEditData().getCardPanel();
        addCustomerAttributes = editDataAttributes.getEditCustomersView();
        addDayAttributes = editDataAttributes.getEditDaysView();
        editBookingsAttributes = editDataAttributes.getEditBookingsView().getCardPanel();
        editBookingsButtonPanelAttributes = editDataAttributes.getEditBookingsView().getButtonPanel();
        addBookingAttributes = editBookingsAttributes.getAddBookingView();
        cancelBookingAttributes = editBookingsAttributes.getCancelBookingView();
        editFlightsAttributes = editDataAttributes.getEditFlightsView().getCardPanel();
        editFlightsButtonPanelAttributes = editDataAttributes.getEditFlightsView().getButtonPanel();
        addFlightAttributes = editFlightsAttributes.getAddFlightView();
        cancelFlightAttributes = editFlightsAttributes.getCancelFlightView();
        
        checkStatusAttributes = view.getInterfacePanel().getCheckStatus().getCardPanel();
        checkCustomerAttributes = checkStatusAttributes.getCheckCustomerStatusView();
        checkFlightAttributes = checkStatusAttributes.getCheckFlightStatusView();
        checkWaitlistAttributes = checkStatusAttributes.getCheckWaitlistStatusView();
        
        editDataButtonPanelAttributes = view.getInterfacePanel().getEditData().getButtonPanel();
        checkStatusButtonPanelAttributes = view.getInterfacePanel().getCheckStatus().getButtonPanel();
        
        buttonOptionsPanel = view.getButtonPanel();
        interfacePanel = view.getInterfacePanel();
        dataPanel = view.getDataPanel();
        
        setUpAddCustomerAttributes();
        setUpAddDayAttributes();
        setUpAddBookingAttributes();
        setUpCancelBookingAttributes();
        setUpAddFlightAttributes();      
        setUpCancelFlightAttributes();      
        setUpCheckCustomerAttributes(); 
        setUpCheckFlightAttributes();
        setUpCheckWaitlistAttributes();
        setUpEditDataButtonPanelAttributes();
        setUpCheckStatusButtonPanelAttributes();
        setUpButtonOptionsPanelAttributes();
                    
                    
    }
    
    public void setUpAddCustomerAttributes() {
        addCustomerAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String customerName = addCustomerAttributes.getAddCustomerTextField().getText();
            if (!customerName.isEmpty()) {
                Customer.addCustomer(customerName);  
            }
            addCustomerAttributes.clearEntry();
            // show on data table
            addCustomerAttributes.updateView();
        });
        
    }
    public void setUpAddDayAttributes() {
        addDayAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String day = addDayAttributes.getAddDayTextField().getText();
            if (!day.isEmpty()) {
                Day.addDay(day);
            }
            addDayAttributes.clearEntry();
            // update database
            // show on data table
            addDayAttributes.updateView();
        });
    }
    public void setUpAddBookingAttributes() {
        addBookingAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String customerName = "";
            String flightName = "";
            String day = "";
            try {
                customerName = addBookingAttributes.getCustomerComboBox().getSelectedItem().toString();
                flightName = addBookingAttributes.getFlightComboBox().getSelectedItem().toString();
                day = addBookingAttributes.getDayComboBox().getSelectedItem().toString();
                Booking.addBooking(flightName, day, customerName);
                dataPanel.setCurrentMode("All");
            } catch (java.lang.NullPointerException j) {
                System.out.println("Null Pointer Exception Raised");
            }
            dataPanel.updateView();
            //addBookingAttributes.updateView();
        });
        
    }
    public void setUpCancelBookingAttributes() {
        cancelBookingAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String customerName = "";
            String day = "";
            try {
                customerName = cancelBookingAttributes.getCustomerComboBox().getSelectedItem().toString();
                day = cancelBookingAttributes.getDayComboBox().getSelectedItem().toString();
                Booking.cancelBooking(customerName, day);
                dataPanel.setCurrentMode("All");
            } catch(NullPointerException n) {
                System.out.println("Empty JComboBox");
            }
            dataPanel.updateView();
            
        });
        
    }
    public void setUpAddFlightAttributes() {
        addFlightAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String flightName = addFlightAttributes.getAddFlightTextField().getText();
            int flightCapacity = 2;
            try {
                flightCapacity = Integer.parseInt(addFlightAttributes.getCapacityTextField().getText());
            } catch (java.lang.NumberFormatException j) {
                System.out.println("Not an Integer, defaulting at 2");
            }
            if (!(addFlightAttributes.getAddFlightTextField().getText().isEmpty())) {
                Flight.addFlight(flightName, flightCapacity);
            }
            addFlightAttributes.clear();
            // show on data table
            addFlightAttributes.updateView();
            
        });
        
    }
    public void setUpCancelFlightAttributes() {
        cancelFlightAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String flightName = "";
            try {
                flightName = cancelFlightAttributes.getFlightComboBox().getSelectedItem().toString();
                Flight.dropFlight(flightName);
                dataPanel.setCurrentMode("All");
            } catch(NullPointerException n) {
                System.out.println("Empty JComboBox");
            }
            dataPanel.updateView();
            cancelFlightAttributes.updateView();
            
        });
        
    }
    public void setUpCheckCustomerAttributes() {
        checkCustomerAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String customerQuery = "";
            try {
                customerQuery = checkCustomerAttributes.getCustomerComboBox().getSelectedItem().toString();
                dataPanel.setCustomerQuery(customerQuery);
                dataPanel.setCurrentMode("CUSTOMER");
            } catch(NullPointerException n) {
                System.out.println("Empty JComboBox");
            }
            dataPanel.updateView();
            
        });
        
    }
    public void setUpCheckFlightAttributes() {
        checkFlightAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String flightQuery = "";
            String dayQuery = "";
            try {
                flightQuery = checkFlightAttributes.getFlightComboBox().getSelectedItem().toString();
                dayQuery = checkFlightAttributes.getDayComboBox().getSelectedItem().toString();
                dataPanel.setFlightQuery(flightQuery);
                dataPanel.setDayQuery(dayQuery);
                dataPanel.setCurrentMode("FLIGHT");
            } catch(NullPointerException n) {
                System.out.println("Empty JComboBox");
            }
            dataPanel.updateView();
            
        });
        
    }
    public void setUpCheckWaitlistAttributes() {
        checkWaitlistAttributes.getExecute().addActionListener((ActionEvent e) -> {
            String dayQuery = "";
            try {
                dataPanel.setDayQuery(checkWaitlistAttributes.getDayComboBox().getSelectedItem().toString());
                dataPanel.setCurrentMode("WAITLIST");
            } catch (java.lang.NullPointerException j) {
                System.out.println("Null Pointer Exception");
            }
            dataPanel.updateView();
            
        });
        
    }
    
    public void setUpEditDataButtonPanelAttributes() {
        editDataButtonPanelAttributes.getEditCustomers().addActionListener((ActionEvent e) -> {
            addCustomerAttributes.updateView();
            editDataAttributes.changeCard("editCustomers");
        });
        editDataButtonPanelAttributes.getEditDays().addActionListener((ActionEvent e) -> {
           addDayAttributes.updateView();
           editDataAttributes.changeCard("editDays");
        });
        editDataButtonPanelAttributes.getEditBookings().addActionListener((ActionEvent e) -> {
           addBookingAttributes.updateView();
           cancelBookingAttributes.updateView();
           editDataAttributes.changeCard("editBookings");
        });
        // Also update Edit Bookings View internally
        editBookingsButtonPanelAttributes.getAddBooking().addActionListener((ActionEvent e) -> {
            addBookingAttributes.updateView();
            editBookingsAttributes.changeCard("addBooking");
        });
        editBookingsButtonPanelAttributes.getCancelBooking().addActionListener((ActionEvent e) -> {
            cancelBookingAttributes.updateView();
            editBookingsAttributes.changeCard("cancelBooking");
        });
        editDataButtonPanelAttributes.getEditFlights().addActionListener((ActionEvent e) -> {
            addFlightAttributes.updateView();
            cancelFlightAttributes.updateView();
            editDataAttributes.changeCard("editFlights");
        });
        // Also update Edit Flights View internally
        editFlightsButtonPanelAttributes.getAddFlight().addActionListener((ActionEvent e) -> {
            addFlightAttributes.updateView();
            editFlightsAttributes.changeCard("addFlight");
        });
        editFlightsButtonPanelAttributes.getCancelFlight().addActionListener((ActionEvent e) -> {
            cancelFlightAttributes.updateView();
            editFlightsAttributes.changeCard("cancelFlight");
        });
        
    }
    
    public void setUpCheckStatusButtonPanelAttributes() {
        checkStatusButtonPanelAttributes.getCheckCustomer().addActionListener((ActionEvent e) -> {
            checkCustomerAttributes.updateView();
            checkStatusAttributes.changeCard("checkCustomer");
        });
        checkStatusButtonPanelAttributes.getCheckFlight().addActionListener((ActionEvent e) -> {
            checkFlightAttributes.updateView();
            checkStatusAttributes.changeCard("checkFlight");
        });
        checkStatusButtonPanelAttributes.getCheckWaitlist().addActionListener((ActionEvent e) -> {
            checkWaitlistAttributes.updateView();
            checkStatusAttributes.changeCard("checkWaitlist");
        });
        checkStatusButtonPanelAttributes.getViewAllBookingsAndWaitlist().addActionListener((ActionEvent e) -> {
            dataPanel.setCurrentMode("All");
            dataPanel.updateView();
        });
    }
    
    public void setUpButtonOptionsPanelAttributes() {
        buttonOptionsPanel.getEditData().addActionListener((ActionEvent e) -> {
            addCustomerAttributes.updateView();
            addDayAttributes.updateView();
            addBookingAttributes.updateView();
            cancelBookingAttributes.updateView();
            addFlightAttributes.updateView();
            cancelFlightAttributes.updateView();
            interfacePanel.changeCard("editData");
            
        });
        buttonOptionsPanel.getCheckStatus().addActionListener((ActionEvent e) -> {
            checkCustomerAttributes.updateView();
            checkFlightAttributes.updateView();
            checkWaitlistAttributes.updateView();
            interfacePanel.changeCard("checkStatus");
        });
    }
    
}

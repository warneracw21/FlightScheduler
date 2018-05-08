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
public class StatusCardPanel extends CardPanel {
    private CheckCustomerStatus checkCustomerStatusView;
    private CheckFlightStatus checkFlightStatusView;
    private CheckWaitlistStatus checkWaitlistStatusView;
    
    public StatusCardPanel() {
        super();
        
        checkCustomerStatusView = new CheckCustomerStatus();
        checkFlightStatusView = new CheckFlightStatus();
        checkWaitlistStatusView = new CheckWaitlistStatus();
        
        add(checkCustomerStatusView, "checkCustomer");
        add(checkFlightStatusView, "checkFlight");
        add(checkWaitlistStatusView, "checkWaitlist");
    }

    public CheckCustomerStatus getCheckCustomerStatusView() {
        return checkCustomerStatusView;
    }

    public CheckFlightStatus getCheckFlightStatusView() {
        return checkFlightStatusView;
    }

    public CheckWaitlistStatus getCheckWaitlistStatusView() {
        return checkWaitlistStatusView;
    }
    
    
    
}

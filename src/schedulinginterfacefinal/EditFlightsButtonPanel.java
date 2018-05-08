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
public class EditFlightsButtonPanel extends JPanel {
    private JButton addFlight;
    private JButton cancelFlight;
    
    public EditFlightsButtonPanel() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridLayout(1,2) );
        addFlight = new JButton("Add Flight");
        cancelFlight = new JButton("Cancel Flight");
        
        add(addFlight);
        add(cancelFlight);
    }

    public JButton getAddFlight() {
        return addFlight;
    }

    public JButton getCancelFlight() {
        return cancelFlight;
    }
    
    
}

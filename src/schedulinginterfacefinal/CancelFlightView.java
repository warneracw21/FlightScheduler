/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class CancelFlightView extends JPanel {
    private JLabel cancelFlightLabel;
    private JLabel flightLabel;
    private FlightComboBox flightComboBox;
    private JButton execute;
    
    public CancelFlightView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        cancelFlightLabel = new JLabel("Cancel Flight");
        cancelFlightLabel.setHorizontalAlignment(JLabel.CENTER);
        cancelFlightLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(cancelFlightLabel, c);
        
        flightLabel = new JLabel("Flight ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(flightLabel, c);
        
        flightComboBox = new FlightComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(flightComboBox, c);
        
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(execute, c);
        
        
    }

    public JLabel getCancelFlightLabel() {
        return cancelFlightLabel;
    }

    public FlightComboBox getFlightComboBox() {
        return flightComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getFlightComboBox().updateComboBox();
        
    }
    
    
}

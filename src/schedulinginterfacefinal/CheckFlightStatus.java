/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class CheckFlightStatus extends JPanel {
    private JLabel checkFlightLabel;
    private JLabel flightLabel;
    private FlightComboBox flightComboBox;
    private JLabel dayLabel;
    private DayComboBox dayComboBox;
    private JButton execute;
    
    public CheckFlightStatus() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        checkFlightLabel = new JLabel("Check Flight Status");
        checkFlightLabel.setHorizontalAlignment(JLabel.CENTER);
        checkFlightLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(checkFlightLabel,c);
        flightLabel = new JLabel("Flight ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(flightLabel,c);
        flightComboBox = new FlightComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(flightComboBox,c);
        dayLabel = new JLabel("Day ");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        add(dayLabel,c);
        dayComboBox = new DayComboBox();
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        add(dayComboBox,c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(execute,c);
        
    }

    public JLabel getCheckFlightLabel() {
        return checkFlightLabel;
    }

    public FlightComboBox getFlightComboBox() {
        return flightComboBox;
    }

    public DayComboBox getDayComboBox() {
        return dayComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getFlightComboBox().updateComboBox();
        getDayComboBox().updateComboBox();
    }
    
    
    
}

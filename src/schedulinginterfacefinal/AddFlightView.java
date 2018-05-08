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
public class AddFlightView extends JPanel {
    private JLabel addFlightLabel;
    private JLabel flightLabel;
    private JTextField addFlightTextField;
    private JLabel capacityLabel;
    private JTextField capacityTextField;
    private JButton execute;
    
    public AddFlightView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        addFlightLabel = new JLabel("Add New Flight");
        addFlightLabel.setHorizontalAlignment(JTextField.CENTER);
        addFlightLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(addFlightLabel, c);
        flightLabel = new JLabel("Flight Name ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(flightLabel, c);
        addFlightTextField = new JTextField(10);
        addFlightTextField.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(addFlightTextField, c);
        capacityLabel = new JLabel("Capacity ");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        add(capacityLabel,c);
        capacityTextField = new JTextField(5);
        capacityTextField.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 1; c.gridy = 2; c.gridwidth = 1;
        add(capacityTextField,c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(execute, c);

    }

    public JLabel getAddFlightLabel() {
        return addFlightLabel;
    }

    public JTextField getAddFlightTextField() {
        return addFlightTextField;
    }

    public JTextField getCapacityTextField() {
        return capacityTextField;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void clear() {
        addFlightTextField.setText("");
        capacityTextField.setText("");
    }
    
    public void updateView() {
        
    }
    
    
}

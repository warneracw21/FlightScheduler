/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.GridBagLayout;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author andrewwarner
 */
public class CheckCustomerStatus extends JPanel {
    private JLabel checkCustomerStatusLabel;
    private JLabel customerLabel;
    private CustomerComboBox customerComboBox;
    private JButton execute;
    
    public CheckCustomerStatus() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        checkCustomerStatusLabel = new JLabel("Check Customer Status");
        checkCustomerStatusLabel.setHorizontalAlignment(JLabel.CENTER);
        checkCustomerStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(checkCustomerStatusLabel,c);
        customerLabel = new JLabel("Customer ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(customerLabel,c);
        customerComboBox = new CustomerComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(customerComboBox,c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        add(execute,c);
        
        
        
        
        
        
        
    }

    public JLabel getCheckCustomerStatusLabel() {
        return checkCustomerStatusLabel;
    }

    public CustomerComboBox getCustomerComboBox() {
        return customerComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getCustomerComboBox().updateComboBox();        
    }
    
    
    
}

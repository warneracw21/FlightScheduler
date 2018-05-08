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
public class AddCustomerView extends JPanel {
    private JLabel addCustomerLabel;
    private JTextField addCustomerTextField;
    private JButton execute;
    
    public AddCustomerView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        addCustomerLabel = new JLabel("Add New Customer");
        addCustomerLabel.setHorizontalAlignment(JTextField.CENTER);
        addCustomerLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0;
        add(addCustomerLabel, c);
        addCustomerTextField = new JTextField(15);
        addCustomerTextField.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 0; c.gridy = 1;
        add(addCustomerTextField,c) ;
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 2;
        add(execute,c);
    }

    public JLabel getAddCustomerLabel() {
        return addCustomerLabel;
    }

    public JTextField getAddCustomerTextField() {
        return addCustomerTextField;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void clearEntry() {
        addCustomerTextField.setText("");
    }
    
    public void updateView() {
        
    }
    
}

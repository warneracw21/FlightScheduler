/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author andrewwarner
 */
public class AddDayView extends JPanel {
    private JLabel addDayLabel;
    private JTextField addDayTextField;
    private JButton execute;
    
    public AddDayView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        addDayLabel = new JLabel("Add New Day");
        addDayLabel.setHorizontalAlignment(JTextField.CENTER);
        addDayLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0;
        add(addDayLabel,c);
        addDayTextField = new JTextField(15);
        addDayTextField.setHorizontalAlignment(JTextField.CENTER);
        c.gridx = 0; c.gridy = 1;
        add(addDayTextField,c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 2;
        add(execute,c);
    }

    public JLabel getAddDayLabel() {
        return addDayLabel;
    }

    public JTextField getAddDayTextField() {
        return addDayTextField;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void clearEntry() {
        addDayTextField.setText("");
    }
    
    public void updateView() {
        
    }

    
    
}

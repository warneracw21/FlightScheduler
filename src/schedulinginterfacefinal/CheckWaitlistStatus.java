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
public class CheckWaitlistStatus extends JPanel {
    private JLabel checkWaitlistStatusLabel;
    private JLabel dayLabel;
    private DayComboBox dayComboBox;
    private JButton execute;

    public CheckWaitlistStatus() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        checkWaitlistStatusLabel = new JLabel("Check Waitlist Status");
        checkWaitlistStatusLabel.setHorizontalAlignment(JLabel.CENTER);
        checkWaitlistStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(checkWaitlistStatusLabel,c);
        dayLabel = new JLabel("Day ");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        add(dayLabel,c);
        dayComboBox = new DayComboBox();
        c.gridx = 1; c.gridy = 1; c.gridwidth = 1;
        add(dayComboBox,c);
        execute = new JButton("Execute");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        add(execute,c);
        
    }
    
    public JLabel getCheckWaitlistStatusLabel() {
        return checkWaitlistStatusLabel;
    }

    public DayComboBox getDayComboBox() {
        return dayComboBox;
    }

    public JButton getExecute() {
        return execute;
    }
    
    public void updateView() {
        getDayComboBox().updateComboBox();
        
        
    }
    
}

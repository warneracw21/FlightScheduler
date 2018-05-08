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
public class ButtonOptionsPanel extends JPanel {
    private JButton editData;
    private JButton checkStatus;
    
    public ButtonOptionsPanel() {
        setBackground(Color.decode("#F2EEE2"));
        setLayout( new GridLayout(1,2) );
        editData = new JButton("Edit Data");   
        checkStatus = new JButton("Check Status");   
        add(editData);
        add(checkStatus);
    }

    public JButton getEditData() {
        return editData;
    }

    public JButton getCheckStatus() {
        return checkStatus;
    }
    
    
    
}

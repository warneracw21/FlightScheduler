/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author andrewwarner
 */
public class View extends JFrame {
    private ButtonOptionsPanel buttonPanel;
    private InterfacePanel interfacePanel;
    private DataPanel dataPanel;
    
    public View() {
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        setMinimumSize( new Dimension(1000, 300) );
        c.fill = GridBagConstraints.BOTH;
        
        buttonPanel = new ButtonOptionsPanel();
        c.gridx = 0; c.gridy = 0; c.weighty = 0.5; c.gridwidth = 2;
        add(buttonPanel, c);
        interfacePanel = new InterfacePanel();
        c.gridx = 0; c.gridy = 1; c.weighty = 2.0; c.gridwidth = 1;
        add(interfacePanel, c);
        dataPanel = new DataPanel();
        c.gridx = 1; c.gridy = 1; c.weighty = 2.0; c.weightx = 2.0; c.gridwidth = 1;
        add(dataPanel, c);
        
    }

    public ButtonOptionsPanel getButtonPanel() {
        return buttonPanel;
    }

    public InterfacePanel getInterfacePanel() {
        return interfacePanel;
    }
    
    public DataPanel getDataPanel() {
        return this.dataPanel;
    }
    
}

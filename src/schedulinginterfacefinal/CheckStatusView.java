/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class CheckStatusView extends JPanel {
    private StatusCardPanel cardPanel;
    private StatusButtonPanel buttonPanel;
    
    public CheckStatusView() {
        setLayout( new GridLayout(1,2) );
        
        cardPanel = new StatusCardPanel();
        buttonPanel = new StatusButtonPanel();
        
        add(buttonPanel);
        add(cardPanel);
        
        
    }

    public StatusCardPanel getCardPanel() {
        return cardPanel;
    }

    public StatusButtonPanel getButtonPanel() {
        return buttonPanel;
    }
    
    
}

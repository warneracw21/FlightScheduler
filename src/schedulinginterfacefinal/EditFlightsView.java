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
public class EditFlightsView extends JPanel {
    private EditFlightsButtonPanel buttonPanel;
    private EditFlightsCardPanel cardPanel;
    
    public EditFlightsView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        buttonPanel = new EditFlightsButtonPanel();
        c.gridx = 0; c.gridy = 0; c.weighty = 0.5;
        add(buttonPanel, c);
        cardPanel = new EditFlightsCardPanel();
        c.gridx = 0; c.gridy = 1; c.weighty = 2.0;
        add(cardPanel, c);
        
    }

    public EditFlightsButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public EditFlightsCardPanel getCardPanel() {
        return cardPanel;
    }
    
    
}

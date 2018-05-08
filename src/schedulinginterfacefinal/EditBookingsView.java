/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.*;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class EditBookingsView extends JPanel {
    private EditBookingsButtonPanel buttonPanel;
    private EditBookingsCardPanel cardPanel;

    public EditBookingsView() {
        setBackground(Color.decode("#F5F5F5"));
        setLayout( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();
        
        buttonPanel = new EditBookingsButtonPanel();
        c.gridx = 0; c.gridy = 0; c.weighty = 0.5;
        add(buttonPanel,c);
        cardPanel = new EditBookingsCardPanel();
        c.gridx = 0; c.gridy = 1; c.weighty = 2;
        add(cardPanel,c);
    }
    
    public EditBookingsButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public EditBookingsCardPanel getCardPanel() {
        return cardPanel;
    }
    
    
}

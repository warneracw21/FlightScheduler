/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class EditDataView extends JPanel {
    private EditDataButtonPanel buttonPanel;
    private EditDataCardPanel cardPanel;
    
    public EditDataView() {
        setLayout( new GridLayout(1,2) );
        buttonPanel = new EditDataButtonPanel();
        cardPanel = new EditDataCardPanel();
        
        add(buttonPanel);
        add(cardPanel);
    }

    public EditDataButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public EditDataCardPanel getCardPanel() {
        return cardPanel;
    }
    
    
}

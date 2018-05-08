/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author andrewwarner
 */
public class CardPanel extends JPanel {
    public CardLayout cardLayout;
    
    public CardPanel() {
        cardLayout = new CardLayout();
        setLayout ( cardLayout );
    }
    
    public void changeCard(String cardID) {
        cardLayout.show(this, cardID);
    }
    
}

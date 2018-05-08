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
public class InterfacePanel extends CardPanel {
    private EditDataView editData;
    private CheckStatusView checkStatus;
    
    public InterfacePanel() {
        super();
        
        editData = new EditDataView();
        checkStatus = new CheckStatusView();
        
        add(editData, "editData");
        add(checkStatus, "checkStatus");
        
        cardLayout.show(this, "editData");
        
    }

    public EditDataView getEditData() {
        return editData;
    }

    public CheckStatusView getCheckStatus() {
        return checkStatus;
    }
}

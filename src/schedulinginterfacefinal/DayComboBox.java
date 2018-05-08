/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import javax.swing.JComboBox;

/**
 *
 * @author andrewwarner
 */
public class DayComboBox extends JComboBox {
    
    public DayComboBox() {
        Day.getAllDays().forEach((day) -> { addItem(day.toString()); });
    }
    
    public void updateComboBox() {
        removeAllItems();
        Day.getAllDays().forEach((day) -> { addItem(day.toString()); });
        
    }
    
}

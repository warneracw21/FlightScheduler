/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulinginterfacefinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author andrewwarner
 */
public class CustomerComboBox extends JComboBox {
    
    public CustomerComboBox() {
        List<Customer> customers = Customer.getAllCustomers();
        if (customers.isEmpty()) {
            addItem("");
        } else {
            customers.forEach((customer) -> {addItem(customer.toString());}); 
        }
    }
    
    public void updateComboBox() {
        removeAllItems();
        Customer.getAllCustomers().forEach((customer) -> {addItem(customer.toString());});
        
    }
    
}

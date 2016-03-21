/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeadvisor;

import java.time.LocalDate;
import javax.swing.DefaultListModel;

/**
 *
 * @author joomlah
 */
public class FormData {

    private DefaultListModel model;

    private double payRate;
    private double workHours;
    private double totalIncome;
    private double totalSpending;

    private double grandTotal;

    public FormData() {
        payRate = 8.2;
        workHours = 25;

        totalIncome = payRate * workHours;

        totalSpending = 0;
        grandTotal = 0;

        model = new DefaultListModel();
        model.addElement(new PaymentEntry("Krogers", 42.58, "Food / Junk", LocalDate.of(2016, 3, 2)));
        model.addElement(new PaymentEntry("Krogers", 23.91, "Bread / Junk"));
        model.addElement(new PaymentEntry("Krogers", 32.19, "Food"));
//        model.addElement(new PaymentEntry("Arbys", 8.48));
//        model.addElement(new PaymentEntry("Krogers", 7.29, "Break Snack"));
//        model.addElement(new PaymentEntry("Krogers", 22.27, "Pizza, Yogurt, Duster"));
//        model.addElement(new PaymentEntry("Krogers", 17.02, "Pizza, Pop, Junk"));
//        model.addElement(new PaymentEntry("Krogers", 20.95, "Pizza, Cookie, Applesauce, TP"));
//        model.addElement(new PaymentEntry("Arbys", 8.48));
//        model.addElement(new PaymentEntry("Arbys", 8.48));
//        model.addElement(new PaymentEntry("Krogers", 6.99, "Break Snack"));
//        model.addElement(new PaymentEntry("Krogers", 31.89, "Food Applesauce, Junk, Pop"));
//        model.addElement(new PaymentEntry("Blizzard", 59.99, "Overwatch: Origins Edition"));
//        model.addElement(new PaymentEntry("Blizzard", 14.99, "SC2 Nova Missions"));
//        model.addElement(new PaymentEntry("Steam", 20.00, "Factorio"));
//        model.addElement(new PaymentEntry("Steam", 59.99, "Hitman"));
//        model.addElement(new PaymentEntry("Krogers", 72.02, "Luxery"));
//        model.addElement(new PaymentEntry("Arbys", 8.48));
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double d) {
        payRate = d;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double d) {
        workHours = d;
    }

    public double getTotalIncome() {
        totalIncome = workHours * payRate;
        return totalIncome;
    }

    public double getTotalSpending() {
        double spending = 0;
        for (int i = 0; i < model.getSize(); i++) {
            PaymentEntry paymentEntry = (PaymentEntry) model.getElementAt(i);
            
            spending += paymentEntry.getValue();
        }
        totalSpending = spending;
        return totalSpending;
    }

    public double getGrandTotal() {
        grandTotal = totalIncome - getTotalSpending();
        
        return grandTotal;
    }

    public DefaultListModel getModel() {
        return model;
    }

    public void setModel(DefaultListModel model) {
        this.model = model;
    }
    
    
}

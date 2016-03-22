/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeadvisor;

import java.time.LocalDate;

/**
 *
 * @author joomlah
 */
public class PaymentEntry {
    
    private String name;
    private double value;
    private String description;
    private LocalDate date;
    private String dateString;

    public PaymentEntry(String name, double amount) {
        this.name = name;
        this.value = amount;
        this.description = "Not added.";
        date = LocalDate.now();
    }

    public PaymentEntry(String name, double value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.description = "Not added.";
        this.date = date;
    }
    
    
    public PaymentEntry(String name, double amount, String des) {
        this.name = name;
        this.value = amount;
        this.description = des;
        date = LocalDate.now();
    }
    public PaymentEntry(String name, double amount, String des, LocalDate date) {
        this.name = name;
        this.value = amount;
        this.description = des;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public String getDateString() {
        int m = date.getMonthValue();
        int d = date.getDayOfMonth();
        int y = date.getYear();
        
        dateString = m + "/" + d + "/" + y;
        
        return dateString;
    }
    
    public void setName(String s) {
        name = s;
    }
    
    public void setValue(double d) {
        value = d;
    }
    
    public void setDescription(String s) {
        description = s;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    /*
    * This is strictly for viewing in the List Model!
    */
    @Override
    public String toString() {
        return name + " -- $" + value;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeadvisor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author joomlah
 */
public class Tool {
    
    public static String roundToString(double value) {
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return Double.toString(bd.doubleValue());
    }
    
    public static String parseDateToString(int month, int day, int year) {
        //y m d
        LocalDate d = LocalDate.of(year, month, day);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/uuuu");
        
        String s = d.format(format);
        
        System.out.println("[Tool.parseDate()] -- DBG: " + s);
        
        return s;
    }
    
    public static LocalDate parseDate(String s) {

        String[] dateInfo = s.split("/");
        
        String date = dateInfo[0] + "/" + dateInfo[1] + "/" + dateInfo[2];
        
        int year = Integer.parseInt(dateInfo[2]);
        int month = Integer.parseInt(dateInfo[0]);
        int day = Integer.parseInt(dateInfo[1]);
        
        // Y M D
        LocalDate ld = LocalDate.of(year, month, day);
        
        return ld;
    }
    
}

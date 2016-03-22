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
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

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
        
        System.out.println("[Tool.parseDate(int, int, int)] -- DBG: " + s);
        
        return s;
    }
    
    public static String parseDateToString(LocalDate ld) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/uuuu");
        
        String s = ld.format(format);
        
        System.out.println("[Tool.parseDate(LocalDate)] -- DBG: " + s);
        
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
    
    public static enum SortType {
        ASCEND,
        DESCEND,
    }
    
    public static void sortList(DefaultListModel model, SortType sort) {
  
        
        PaymentEntry[] peArray = new PaymentEntry[model.size()];
        
        for (int i = 0; i < peArray.length; i++) {
            peArray[i] = (PaymentEntry) model.get(i);
        }
        
        
        int i, j = 0;
        PaymentEntry key;
        for (i = 1; i < peArray.length; i++) {
            key = peArray[i];
            if (sort == SortType.DESCEND) {
                for (j = i - 1; (j >= 0) && (peArray[j].getValue() < key.getValue()); j--) {
                    peArray[j + 1] = peArray[j];
                }
            } else if (sort == SortType.ASCEND) {
                for (j = i - 1; (j >= 0) && (peArray[j].getValue() > key.getValue()); j--) {
                    peArray[j + 1] = peArray[j];
                }
            }
            
            peArray[j + 1] = key;
        }
        
        model.clear();
        for (PaymentEntry peArray1 : peArray) {
            model.addElement(peArray1);
        }
    }
    
    /**
     * May not be needed.
     * Was designed to extract date info from a DefaultListModel
     * and insert that data into a raw int[] array to be manipulated.
     */
    
//    private enum ArrayType {
//        DAY,
//        MONTH
//    }
    

//    private static int[] parseArrayType(DefaultListModel model, ArrayType type) {
//        
//        List<Integer> values = new ArrayList<>();
//        PaymentEntry paymentEntry;
//        int[] valueArray;
//        
//        for (int i = 0; i < model.getSize(); i++) {
//            paymentEntry = (PaymentEntry) model.get(i);
//            switch(type){
//                case DAY:
//                    values.add(paymentEntry.getDate().getDayOfMonth());
//                    break;
//                case MONTH:
//                    values.add(paymentEntry.getDate().getMonthValue());
//                    break;
//            }
//        } 
//
//        valueArray = new int[values.size()];
//        
//        for (int i = 0; i < valueArray.length; i++) {
//            valueArray[i] = values.get(i);
//        }
//        
//        return valueArray;
//        
//    }
    
}

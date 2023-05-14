/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.*;

/**
 *
 * @author sctcad
 */
public class Khoja_MonthMap implements Khoja_MonthLookup {
    
    private Map<Integer, Khoja_MonthPair> months;
    
    public Khoja_MonthMap()
    {
        months = new HashMap<Integer, Khoja_MonthPair>();
        addMonth(new Khoja_MonthPair(1, "January"));
        addMonth(new Khoja_MonthPair(2, "February"));
        addMonth(new Khoja_MonthPair(3, "March"));
        addMonth(new Khoja_MonthPair(4, "April"));
        addMonth(new Khoja_MonthPair(5, "May"));
        addMonth(new Khoja_MonthPair(6, "June"));
        addMonth(new Khoja_MonthPair(7, "July"));
        addMonth(new Khoja_MonthPair(8, "August"));
        addMonth(new Khoja_MonthPair(9, "September"));
        addMonth(new Khoja_MonthPair(10, "October"));
        addMonth(new Khoja_MonthPair(11, "November"));
        addMonth(new Khoja_MonthPair(12, "December"));
    }
    private void addMonth(Khoja_MonthPair month) 
    {
        months.put(month.getMonthNumber(), month);
    }
    public Khoja_MonthPair findMonth(int monthNumber)
    {
        if(monthNumber != 0)
        {
            return months.get(monthNumber);
        }
        else
        {
            return null;
        }
    }
}

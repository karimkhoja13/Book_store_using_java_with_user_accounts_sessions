/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author sctcad
 */
public class Khoja_MonthPair {
    private final int monthNumber;
    private final String monthName;
    
    public Khoja_MonthPair()
    {
        monthNumber = 1;
        monthName = "January";
    }
    
    public Khoja_MonthPair(int monthNum, String monthName)
    {
        this.monthNumber = monthNum;
        this.monthName = monthName;
    }
    
    public int getMonthNumber()
    {
        return monthNumber;
    }
    
    public String getMonthName()
    {
        return monthName;
    }
}

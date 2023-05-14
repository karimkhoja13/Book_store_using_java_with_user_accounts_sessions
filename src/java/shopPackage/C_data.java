/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class C_data {
    private static HashMap<String , String> loginid = new HashMap<String, String>();
    
//    ArrayList<String> pass = new ArrayList<>();
    String passd ="";
    
    public C_data()
    {
        loginid.put("user","pass");
    }
    
    public boolean C_data(String pass, String cpass)
    {
        this.passd=pass;
        if(pass.equals(cpass))
        {
        return true;
        }
        else
        { 
         return false;
        }
    }
    public String C_data(int n1,int n2,int n3, int n4, int n7)
    {
           String msg = "";
       msg = "hi" +loginid;
       return msg; 
    }
    
    public boolean C_data(String email)
    {
            if(loginid.containsKey(email) )
            {
                return false;
            }
            else
            {
                this.loginid.put(email,passd);
                return true;
                
            }
    }
    public String C_data(String email,String pass,String email1,String email2)
    {
        String msg = "";
       this.loginid.put(email,pass);
       msg = "hi" +loginid;
       return msg;
       
    }
    public boolean C_data(String email,String cpass,String passd)
    {
        String confirms="";
        if(loginid.containsKey(email))
        {
            confirms= loginid.get(email);
            if(confirms.equals(cpass))
            {
              return true;  
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }
}
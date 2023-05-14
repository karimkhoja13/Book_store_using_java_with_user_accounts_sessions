/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sctcad
 */
@WebServlet(name = "ShowMonthServlet", urlPatterns = {"/ShowMonthServlet"})
public class ShowMonthServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String monthNumString = request.getParameter("monthNumber");
//        String emailAddress = request.getParameter("emailAddress");
//            if (isMissing(emailAddress)) {
//                emailAddress = "Missing email address";
//            }
            Cookie c1 = new LongLivedCookie("monthNum", monthNumString);
            response.addCookie(c1);
        int monthNumber = -1;
        if(monthNumString.equals(""))
            monthNumber = 0;
        try
        {
            monthNumber = Integer.parseInt(monthNumString);
        }
        catch(Exception e)
        {
        }
        Khoja_MonthLookup service = new Khoja_MonthMap();
        Khoja_MonthPair month = service.findMonth(monthNumber);
        request.setAttribute("monthPair", month);
        String address = "";
        
//        if(monthNumber < 1 || monthNumber > 12)
        if(monthNumber == 0)
        {
            address = "/missing.jsp";
        } 
        else if (month == null) 
        {
            request.setAttribute("badId", monthNumString);
            address = "/unknown.jsp";
        }
//        else if (month != null)
        else
        {
            address = "/good.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    private boolean isMissing(String param) {
        return((param == null) ||
           (param.trim().equals("")));
    }
}

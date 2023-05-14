/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class logoutPage extends HttpServlet {  
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");
            HttpSession session=request.getSession();  
            PrintWriter out=response.getWriter();  
              
            session.invalidate();  
            
            out.println(Catalog.htmlStartString("Logout Redirection"));
            
            out.println("<h2>Logout Redirection</h2>");
            
            out.print("You are successfully logged out!");  
            //response.sendRedirect(null);
            out.println("You will be sent to home page after 5 seconds");
            response.setHeader("Refresh", "5;categoriesHome");
    }  
}  
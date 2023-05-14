/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sctcad
 */
@WebServlet(name = "loginResult", urlPatterns = {"/loginResult"})
public class loginResult extends HttpServlet {

    public static ArrayList user = new ArrayList();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
    response.setContentType("text/html");
     
    //Cookie user = new Cookie("user",request.getParameter("user"));
    
    String error = "";
    boolean isMissingValue = false;
    
    
    String user = request.getParameter("user");
   
    String pass = request.getParameter("pass");
 
   String user_reg =
      getCookieValue(request, user, "");
    String pass_reg =
    getCookieValue(request, pass, "");
    if(user.equals("") && pass.equals(""))
    {
        response.sendRedirect("loginForm?errorCode=0");
    }
    else
    {
        if (user.equals(user_reg) && pass.equals(pass_reg))
        {
            session.setAttribute(user, user);
            session.setAttribute(pass, pass);
            response.sendRedirect("index.html");
        }
        else
            response.sendRedirect("loginForm?errorCode=1");
    }
    
    }
    public static String getCookieValue
                           (HttpServletRequest request,
                            String cookieName,
                            String defaultValue) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for(Cookie cookie: cookies) {
        if (cookieName.equals(cookie.getName())) {
          return(cookie.getValue());
        }
      }
    }
    return(defaultValue);
  }
}

  

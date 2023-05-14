
package shopPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registrationResult", urlPatterns = {"/registrationResult"})
public class registrationResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String cpassword = request.getParameter("cpassword");
    
    Cookie c1 = new LongLivedCookie(username, username);
    
    Cookie c2 = new LongLivedCookie(password, password);
   
    Cookie c3 = new LongLivedCookie(cpassword, cpassword);
    
    
    if(username.equals(""))
    {
        response.sendRedirect("registrationForm?errorCode=0");
    }
    else if(password.equals(""))
    {       
        response.sendRedirect("registrationForm?errorCode=1");
    }
    else if(cpassword.equals(""))
    {       
        response.sendRedirect("registrationForm?errorCode=2");
    }
    else if(!password.equals(cpassword))
    {       
        response.sendRedirect("registrationForm?errorCode=3");
    }
    else
    {
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.sendRedirect("loginForm");
    }
  }
}

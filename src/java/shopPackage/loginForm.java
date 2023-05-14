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

public class loginForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        
    
    String title = "Please Login";
    String errorCode = request.getParameter("errorCode");
        
        out.println(Catalog.htmlStartString(title) +
        "<CENTER>\n" +
        "<H1>" + title + "</H1>\n" +
        "<FORM ACTION=\"loginResult\">\n" +
        "<div class=\"inset\">" +
        "<table><tr><td>" +
        "<label for=\"email\">User ID</label></td>" +
        "<td><INPUT TYPE=\"TEXT\" NAME=\"user\" VALUE=\"\"></td><BR>\n" +
        "</tr>" +
        "<tr>"+
        "<td><label for=\"password\">Password</label></td>"+
        "<td><INPUT TYPE=\"password\" NAME=\"pass\" VALUE=\"\"></td><BR><tr><td colspan = \"2\">\n");
        if (errorCode != null) {
            switch (errorCode) {
                case "0":
                    out.println("<div style='color:red'>You must login!</div>");

                    break;
                case "1":
                    out.println("<div style='color:red'>Username or password invalid!</div>");
                    break;
                case "2":
                    out.println("<div style='color:red'>Wrong Password!</div>");
                    break;
            }
        }
        out.println("</div></td></tr>"+
        "<tr><td colspan=\"2\" align=\"center\">"+
        "<input type=\"submit\" id=\"go\" name=\"go\" value=\"Login\">"+
        "</td></tr>" +
        "</form>"
                + "<tr><td><button type=\"submit\" formaction=\"registrationForm\" />Register (if new user)</td>"+
                 "<td><button type=\"submit\" formaction=\"categoriesHome\" />Go to main page</button></td></tr></table>"+
//                 "<button type=\"submit\" value=\"Button Test\" formaction=\"index.html\" />Button Test</button>"+
//                 "<button type=\"submit\" name=\"button\" value=\"clicked\" formaction=\"index.html\" />Button Test</button>"+
        "</CENTER></BODY></HTML>");
        if(!((request.getParameter("user").equals("")) && (request.getParameter("pass").equals(""))))
        {
            String user = CookieUtilities.getCookieValue(request, request.getParameter("user"), "");
            String pass = CookieUtilities.getCookieValue(request, request.getParameter("pass"), "");
        }
  }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

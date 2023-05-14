/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thomson
 */
@WebServlet(name = "categoriesHome", urlPatterns = {"/categoriesHome"})
public class categoriesHome extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String title = "Categories of Items Page";
            HttpSession session = request.getSession(false);
            out.println(Catalog.htmlStartString(title)
                    + "<h1>" + title + "</h1>\n" +
"        <div>\n" +
"            <table align=center>\n" +
"                <tr align=\"center\">\n" +
"                    <td align=\"center\">\n" +
"                        <a href=\"TechBooksPage\">Technology Books</a>\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td align=\"center\">\n" +
"                        <a href=\"KidsBooksPage\">Kids Books</a>\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td align=\"center\">\n" +
"                        <a href=\"StoryBooksPage\">Story Books</a>\n" +
"                    </td>\n" +
"                </tr>"
                    
                    + "</table>\n");
            if(session == null)
            {
                out.println("<div align=\"center\">\n"
                + "<h3>You have to <a href=\"loginForm\">LOG IN</a> before you can see the products in the above categories in their respective pages.</h3>\n"
                + "<table><tr><td><a href=\"registrationForm\">Register</a> -  If you are a new user</td></tr><tr><td>OR <a href=\"loginForm\">Login</a> -  If you are an existing user</td></tr></table>" +
"                  </div>");
            }
            else
            {
                out.println("<tr><td align=center><br /><br /><a href=\"logoutPage\" />Logout</a></td></tr>");
            }
                out.println("</div>\n" +
"    </body>\n" +
"</html>");
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

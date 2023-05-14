
package shopPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registrationForm extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    

    String title = "Registration Form";
    String errorCode = request.getParameter("errorCode");
        
    out.println(Catalog.htmlStartString(title) +
        "<CENTER>\n" +
        "<H1>" + title + "</H1>\n" +
        "<FORM ACTION=\"registrationResult\">\n" +
        "<div class=\"inset\">" +
        "<table>" +
        "<tr><td><label for=\"email\">User ID</label></td>" +
        "<td><INPUT TYPE=\"TEXT\" NAME=\"username\" VALUE=\"\"></td></tr><BR>\n" +
//        "</p>" +
        "<tr>"+
        "<td><label for=\"password\">Password</label></td>" +
        "<td><INPUT TYPE=\"password\" NAME=\"password\" VALUE=\"\"></td><BR>\n" +
        "</tr>"+
        "<tr>"+
        "<td><label for=\"confirmpassword\">Confirm Password</label></td>"+
        "<td><INPUT TYPE=\"password\" NAME=\"cpassword\" VALUE=\"\"></td>\n" +
        "</tr>" +
        "</div>" +
//        "<p class=\"p-container\">"+
        "<tr><td colspan=\"2\">");
            if (errorCode != null) {
            switch (errorCode) {
                case "0":
                    out.println("<div style='color:red'>Username is Missing!</div>");
                    break;
                case "1":
                    out.println("<div style='color:red'>Password is Missing!</div>");
                    break;
                case "2":
                    out.println("<div style='color:red'>Confirm Password is Missing!</div>");
                    break;
                case "3":
                    out.println("<div style='color:red'>Password and Confirm Password are not matched.!</div>");
                    break;
            }
        }
        out.println("</td>" +
        "</tr>" +
        "<tr>" +
        "<td colspan=\"2\" align=\"right\" valign=\"bottom\"><input type=\"submit\"  id=\"go\" name=\"go\" value=\"Register\"></td>"+
        "</tr>"
                + "<tr><td><br /><br /><br />Other options are given below: </td></tr>"
                + "<tr><td><button type=\"submit\" formaction=\"loginForm\" />Login</button>(If existing user)</td></tr>"
                + "<tr><td><button type=\"submit\" formaction=\"categoriesHome\" />Main Page</button></td></tr>" +
        "</form>" +
        "</CENTER></BODY></HTML>");
        if(!((request.getParameter("username").equals("")) && (request.getParameter("password").equals("")) && (request.getParameter("cpassword").equals(""))))
        {
            String username =
            CookieUtilities.getCookieValue(request, request.getParameter("username"), "");
            String password =
            CookieUtilities.getCookieValue(request, request.getParameter("password"), "");
            String cpassword =
            CookieUtilities.getCookieValue(request, request.getParameter("cpassword"), "");
        }
  }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

<%-- 
    Document   : Khoja_Month
    Created on : Nov 20, 2014, 11:13:30 AM
    Author     : sctcad
--%>

<%@page import="Classes.LongLivedCookie"%>
<%@page import="Classes.CookieUtilities1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String month =
            CookieUtilities1.getCookieValue(request, "monthNum", "");
        %>
        <h1>Khoja, Karim</h1>
        <h1>Month Lookup System</h1>
        <fieldset>
            <legend>Find Month</legend>
            <form action="ShowMonthServlet">
                Month Number (any number between 1 and 12): 
                <input type="text" name="monthNumber" value="<%= month %>"/><br/>
                <input type="submit" value="Show Month Name"/>
            </form>
        </fieldset>

        <% 
            
        %>
    </body>
</html>

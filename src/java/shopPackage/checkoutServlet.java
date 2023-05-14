/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopPackage;

import shopPackage.ItemOrder;
import shopPackage.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;

public class checkoutServlet extends HttpServlet
{
        @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            HttpSession session = request.getSession();
            ShoppingCart cart;
        synchronized(session)
        {
        cart = (ShoppingCart)session.getAttribute("shoppingCart");
        double finalPayment = 0;
// New visitors get a fresh shopping cart.
// Previous visitors keep using their existing cart.
        if(cart == null)
        {
            cart = new ShoppingCart();
            session.setAttribute("shoppingCart", cart);
        }
            String itemID = request.getParameter("itemID");
            if (itemID != null) {
            String numItemsString =
            request.getParameter("numItems");
            if (numItemsString == null) 
            {
// If request specified an ID but no number,
// then customers came here via an "Add Item to Cart"
// button on a catalog page.
                cart.addItem(itemID);
            }
            else
            {
// If request specified an ID and number, then
// customers came here via an "Update Order" button
// after changing the number of items in order.
// Note that specifying a number of 0 results
// in item being deleted from cart.
                int numItems;
                try 
                {
                    numItems = Integer.parseInt(numItemsString);
                }
                catch(NumberFormatException nfe) {
                    numItems = 1;
                }
            cart.setNumOrdered(itemID, numItems);
            }
        }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Your Order";
    out.println(Catalog.htmlStartString(title));
    out.println("<H1 ALIGN=\"CENTER\">" + title + "</H1>");
    
    synchronized(session)
    {
    List itemsOrdered = cart.getItemsOrdered();
    if (itemsOrdered.isEmpty())
    {
        out.println("<H2><I>No items in your cart...</I></H2>");
    }
    else
    {
// If there is at least one item in cart, show table
// of items ordered.
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
           "<TR BGCOLOR=\"#FFAD00\">\n" +
           "  <TH>Item ID<TH>Description\n" +
           "  <TH>Unit Cost<TH>Number<TH>Total Cost");
        ItemOrder order;
// Rounds to two decimal places, inserts dollar
// sign (or other currency symbol), etc., as
// appropriate in current Locale.
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
       
// For each entry in shopping cart, make
// table row showing ID, description, per-item
// cost, number ordered, and total cost.
// Put number ordered in textfield that user
// can change, with "Update Order" button next
// to it, which resubmits to this same page
// but specifying a different number of items.
        for(int i=0; i<itemsOrdered.size(); i++)
        {
            order = (ItemOrder)itemsOrdered.get(i);
            String total = formatter.format(order.getTotalCost());
            finalPayment = finalPayment + order.getTotalCost();
            out.println("<TR>\n" +
                "  <TD>" + order.getItemID() + "\n" +
                "  <TD>" + order.getShortDescription() + "\n" +
                "  <TD>" +
                total + "\n" +
                "  <TD>" +
//                "<FORM>\n" +  // Submit to current URL
//                "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
//                "       VALUE=\"" + order.getItemID() + "\n" + 
                order.getNumItems() + "\n" +
//                "<SMALL>\n" +
//                
//                
//                "</SMALL>\n" +
//                "</FORM>\n" +
                "  <TD>" +
                formatter.format(order.getTotalCost()));
        }
        out.println("</tr></table><p align = center >");
// "Proceed to Checkout" button below table
    }
      out.println("Your total comes off to " + finalPayment
                + "<form action=\"logoutPage\" align =center>"
                + "<input type=\"submit\" value=\"Logout\" /></form></p>"
                + "<a href=\"OrderPage\">Go back to order page</a>"
                + "</BODY></HTML>"
                );
            }
        }
    }
}
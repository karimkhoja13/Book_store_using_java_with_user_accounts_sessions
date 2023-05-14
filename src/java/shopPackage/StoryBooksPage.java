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

/**
 *
 * @author Thomson
 */
@WebServlet(name = "StoryBooksPage", urlPatterns = {"/StoryBooksPage"})
public class StoryBooksPage extends CatalogPage {
    
    
    @Override
    public void init()
    {
        String[] ids = { "7", "8", "9" };
        setItems(ids);
        setTitle("All-Time Best Computer Books");
    }
}


package shopPackage;

import javax.servlet.http.HttpSession;

public class TechBooksPage extends CatalogPage {
    
    
    @Override
    public void init()
    {
        String[] ids = { "4", "5", "6" };
        setItems(ids);
        setTitle("All-Time Best Computer Books");
    }
}
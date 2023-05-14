
package shopPackage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

class CookieUtilities {
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

  /** Given the request object and a name, this method tries
   *  to find and return the cookie that has the given name.
   *  If no cookie matches the name, null is returned.
   */

  public static Cookie getCookie(HttpServletRequest request,
                                 String cookieName) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for(Cookie cookie: cookies) {
        if (cookieName.equals(cookie.getName())) {
          return(cookie);
        }
      }
    }
    return(null);
  } 
}

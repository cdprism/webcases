package org.shancm.webcase.cookiecase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieDemo extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if("name".equals(name)){
                PrintWriter writer = resp.getWriter();
                writer.print(cookie.getValue());
            }
        }
        Cookie cookie = new Cookie("name", "shancm");
        cookie.setMaxAge(5);
        resp.addCookie(cookie);

    }
}

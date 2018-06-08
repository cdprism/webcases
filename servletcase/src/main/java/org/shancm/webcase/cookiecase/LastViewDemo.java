package org.shancm.webcase.cookiecase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LastViewDemo extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解析
        Enumeration<String> attributeNames = request.getAttributeNames();
        Cookie[] cookies = request.getCookies();
        String queryString = request.getQueryString();
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();

        String[] strings = queryString.split("=");

        //2.是否view
        if (!strings[0].startsWith("value")) {
            return;
        }
        Cookie cookie = new Cookie("value" + strings[1], strings[1]);

        //3.repeat
        List<Cookie> list = new ArrayList<>();
        for (Cookie cookie1 : cookies) {
            if (cookie1.getName().startsWith("value")) {
                list.add(cookie1);
            }
        }
        Iterator<Cookie> iterator = list.iterator();
        while (iterator.hasNext()) {
            Cookie next = iterator.next();
            if (next.getName().equals(cookie.getName())) {
                iterator.remove();
                next.setMaxAge(0);
            }
            response.addCookie(next);
        }
        response.addCookie(cookie);
        list.add(cookie);

        //4.quantity 3
        Iterator<Cookie> it = list.iterator();
        while (it.hasNext()) {
            if (list.size() == 4) {
                it.next().setMaxAge(0);
                it.remove();
            }
            it.next();
        }

        //5.out
        PrintWriter writer = response.getWriter();
        for (Cookie n : list) {
            writer.println(n.getName() + " : " + n.getValue());
        }

    }
}

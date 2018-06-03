package org.shancm.webcase.sessioncase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LastViewDemo extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String queryString = req.getQueryString();
        String[] queryStr = queryString.split("=");
        Cookie cookie = new Cookie("value"+queryStr[1], queryStr[1]);

        List<Cookie> cookies = new ArrayList<>();
        Cookie[] cs = req.getCookies();
        for(Cookie c : cs){
            /*if("value".equals(c.getName().substring(0, 5))){
                cookies.add(c);
            }*/
            if(c.getName().startsWith("value")){
                cookies.add(c);
            }
        }


        Iterator<Cookie> iterator = cookies.iterator();
        while (iterator.hasNext()){
            Cookie c = iterator.next();
            if(c.getValue().equals(queryStr[1])){
                iterator.remove();
                cookies.add(cookie);
            }
        }

        if(cookies.size()==6){
            iterator.remove();
        }

        cookie.setMaxAge(60);
        cookies.add(cookie);

        res.addCookie(cookie);

        PrintWriter writer = res.getWriter();
        cookies.forEach(n->{
            writer.println(n.getValue());
        });



    }
}

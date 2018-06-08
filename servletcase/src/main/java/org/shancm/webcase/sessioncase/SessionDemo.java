package org.shancm.webcase.sessioncase;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author shancm
 * @pachage org.shancm.webcase.sessioncase
 * @description:
 * @date 2018/6/5
 */
public class SessionDemo extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean aNew = session.isNew();
        Enumeration<String> names = session.getAttributeNames();
        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
        int interval = session.getMaxInactiveInterval();
        ServletContext servletContext = session.getServletContext();


    }
}

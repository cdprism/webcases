package org.shancm.webcase.servletcase;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DemoServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        System.out.println("ServletName: "+servletConfig.getServletName());
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("name: "+s+"value: "+servletConfig.getInitParameter(s));
        }


        System.out.println("========================");
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("contextPath"+servletContext.getContextPath());
        servletContext.getServletContextName();
        Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()){
            String s = initParameterNames1.nextElement();
            System.out.println("name"+s+" value:"+servletContext.getInitParameter(s));
        }



    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;

    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }



}

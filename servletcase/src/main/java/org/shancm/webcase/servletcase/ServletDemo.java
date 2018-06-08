package org.shancm.webcase.servletcase;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

public class ServletDemo implements Servlet {
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
        String servletContextName = servletContext.getServletContextName();
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
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        String pathInfo = request.getPathInfo();
        Enumeration<String> headerNames = request.getHeaderNames();
//        Collection<Part> parts = request.getParts();
        StringBuffer requestURL = request.getRequestURL();
        Enumeration<String> names = request.getAttributeNames();
        System.out.println("contextPath"+contextPath);
        System.out.println("requestURI"+requestURI);
        System.out.println("pathInfo"+pathInfo);
        System.out.println("requestURL"+requestURL.toString());
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println("headerNames : "+s);
        }
        while (names.hasMoreElements()){
            String s = names.nextElement();
            System.out.println("AttributeNames : "+s);
        }

        ServletContext servletContext = request.getServletContext();
        System.out.println("contextPath"+servletContext.getContextPath());
        servletContext.getServletContextName();
        Enumeration<String> initParameterNames1 = servletContext.getInitParameterNames();
        while (initParameterNames1.hasMoreElements()){
            String s = initParameterNames1.nextElement();
            System.out.println("name"+s+" value:"+servletContext.getInitParameter(s));
        }

        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath "+realPath);

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

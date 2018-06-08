package org.shancm.webcase.filtercase;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author shancm
 * @pachage org.shancm.webcase.filtercase
 * @description:
 * @date 2018/6/5
 */
public class UsernameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ServletContext servletContext = request.getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        String username = "";
        while (initParameterNames.hasMoreElements()){
            String element = initParameterNames.nextElement();
            if(element.startsWith("username")){
                username = servletContext.getInitParameter(element);
            }
        }
        String user = (String)request.getParameter("username");
        /*if (user.equals(username)){
            filterChain.doFilter(servletRequest, servletResponse);
        }*/


        /*PrintWriter writer = response.getWriter();
        writer.println(user);*/

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}

package org.shancm.webcase.filtercase;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author shancm
 * @pachage org.shancm.webcase.filtercase
 * @description:
 * @date 2018/6/6
 */
public class PasswordFilter implements Filter {

    private String passwords;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        passwords = filterConfig.getInitParameter("passwords");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;



        String password = request.getParameter("password");
        if(password.equals(passwords)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }

    @Override
    public void destroy() {
    }
}

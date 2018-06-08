package org.shancm.webcase.filtercase;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shancm
 * @pachage org.shancm.webcase.filtercase
 * @description:
 * @date 2018/6/5
 */
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("second filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after second filter");
    }

    @Override
    public void destroy() {

    }
}

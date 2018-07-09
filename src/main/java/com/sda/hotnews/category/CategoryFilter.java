package com.sda.hotnews.category;

import javax.servlet.*;
import java.io.IOException;

public class CategoryFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("inicjalizacja filtra");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        long end = System.currentTimeMillis();

    }

    @Override
    public void destroy() {
        System.out.println("zabicie filtra");
    }
}

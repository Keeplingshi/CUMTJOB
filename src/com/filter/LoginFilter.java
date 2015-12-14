package com.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpSession session=httpRequest.getSession();
        String path = httpRequest.getRequestURI();
        System.out.println(path);
        if(session.getAttribute("id")!=null&&session.getAttribute("type")!=null){
        	if(path.indexOf("/password.jsp")>-1)
        		chain.doFilter(httpRequest, httpResponse);
        	if(session.getAttribute("type").equals("0"))
            chain.doFilter(request, response);
        	else
                httpResponse.sendRedirect(httpRequest.getContextPath()+"/sclogin.jsp");

        }
        else{
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/sclogin.jsp");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
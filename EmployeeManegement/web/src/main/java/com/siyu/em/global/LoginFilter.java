package com.siyu.em.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        String path=req.getServletPath();

        if(path.toLowerCase().indexOf("login")!=-1&&path.toLowerCase().indexOf("loginlog")==-1) {
            filterChain.doFilter(req, resp);
        }
        else{
            HttpSession httpSession=req.getSession();
            Object obj=httpSession.getAttribute("User");
            if(obj==null)
                resp.sendRedirect(req.getContextPath()+"/toLogin.do");
            else
                filterChain.doFilter(req,resp);
        }

    }

    public void destroy() {

    }
}

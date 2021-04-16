package com.max.project.controller.filter;

import com.max.project.context.PathToPages;
import com.max.project.context.config.AdminConfiguration;
import com.max.project.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class CheckAdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getParameter("command").equals("admin-cabinet")) {
            HttpSession httpSession = req.getSession();
            User user = (User) httpSession.getAttribute("user");
            if (!user.getLogin().equals(AdminConfiguration.getInstance().getLogin())) {
                httpSession.invalidate();
                resp.sendRedirect(PathToPages.HOME_REDIRECT);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

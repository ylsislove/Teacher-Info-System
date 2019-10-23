package com.ylsislove.filter;

import com.ylsislove.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/23 11:04
 */
@WebFilter(filterName = "/research/*")
public class ResearchFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User) request.getSession().getAttribute("user");
        User admin = (User) request.getSession().getAttribute("admin");
        if (user == null && admin == null) {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

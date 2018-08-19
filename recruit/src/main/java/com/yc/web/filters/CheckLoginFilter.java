package com.yc.web.filters;

import static com.yc.utils.YcConstants.LOGINPAGE;
import static com.yc.utils.YcConstants.LOGINUSER;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/resuser/*")
public class CheckLoginFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (session.getAttribute(LOGINUSER) != null) {
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html;charset=utf-8");

			request.getRequestDispatcher(LOGINPAGE).forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

package com.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "/profile.jsp" , "/profile"})
public class WithoutCache implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		httpResponse.setHeader("Cache-Control", // Http
				"private, no-cache, no-store, must-revalidate"); // 1.1

		httpResponse.setHeader("Pragma", "no-cache"); // Http 1.0

		httpResponse.setDateHeader("Expires", 0); // Proxies
		
		HttpSession session = httpRequest.getSession();
		// verfica antes de chegar ao html se existe um usuario autenticado
		Object user = session.getAttribute("user");

		if (user != null) {
			// deixa a requisicao passar para o conteudo
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect(httpRequest.getContextPath()
					+ "/login.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

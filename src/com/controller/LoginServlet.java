package com.controller;

import com.model.SessionUser;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		System.out.println(user);
		
//		User sessionUser = SessionUser.getData().login(user, pwd);
//
//		if (sessionUser != null) {
//			SessionUser.createUserSession(sessionUser);
//			HttpSession session = request.getSession();
//			session.setAttribute("user", sessionUser);
//			// configuracao para a sessao expirar em 30 min
//			session.setMaxInactiveInterval(30 * 60);
//			Cookie userName = new Cookie("user", user);
//			userName.setMaxAge(30 * 60);
//			response.addCookie(userName);
//			response.sendRedirect("index.html");
//
//		} else {
//			RequestDispatcher rd = getServletContext().getRequestDispatcher(
//					"/login.html");
//			PrintWriter out = response.getWriter();
//			out.println("<font color=white>Either user name or password is wrong.</font>");
//			rd.include(request, response);
//		}
	}
}

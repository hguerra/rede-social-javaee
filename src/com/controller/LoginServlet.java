package com.controller;

import com.google.gson.Gson;
import com.model.PersonData;
import com.model.SessionUser;
import com.model.User;

import java.io.BufferedReader;
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
        String user = request.getParameter("firstName");
        String pwd = request.getParameter("lastName");
        String nome = request.getParameter("nome");
        System.out.println(nome);
        System.out.println(user);
        System.out.println(pwd);
//
//        PersonData p = new Gson().fromJson(requestJson(request), PersonData.class);
//
//        if (p == null) {
//            System.out.println("p null");
//        } else {
//            System.out.println(p.getFirstName());
//            System.out.println(p.getLastName());
//        }


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

    public String requestJson(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

package com.controller;

import com.google.gson.Gson;
import com.model.data.Login;
import com.model.user.SessionUser;
import com.model.user.User;
import com.model.util.WebUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        Login toLogin = new Gson().fromJson(json, Login.class);
        User sessionUser = SessionUser.getData().login(toLogin);
        if (sessionUser != null) {
            SessionUser.createUserSession(sessionUser);
            HttpSession session = request.getSession();
            session.setAttribute("user", sessionUser);
            // configuracao para a sessao expirar em 30 min
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", toLogin.getUser());
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            response.sendRedirect("index.jsp");
        } else {
            Callback.onError(response);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=white>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }

}

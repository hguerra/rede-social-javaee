package com.controller;

import com.google.gson.Gson;
import com.model.data.Login;
import com.model.user.PersonData;
import com.model.user.SessionUser;
import com.model.user.User;

import java.io.BufferedReader;
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
        String json = requestJson(request);
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
            response.sendRedirect("index.html");
            Callback.onSuccess(response);
        } else {
            Callback.onError(response);
        }
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

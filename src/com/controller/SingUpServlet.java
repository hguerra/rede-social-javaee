package com.controller;

import com.model.user.SessionUser;
import com.model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by heitor on 07/09/15.
 */
@WebServlet("/signup")
public class SingUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String name = request.getParameter("name");
        String accessName = request.getParameter("accessName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("co-password");
        if (name != null && accessName != null && email != null
                && password != null && confirmPassword != null && !name.isEmpty()
                && !accessName.isEmpty() && !email.isEmpty()
                && !password.isEmpty() && !confirmPassword.isEmpty()
                && confirmPassword.equals(password)) {
            Integer id = SessionUser.getData().getUserId();
            User user = new User(name, accessName, password, id, email);
            SessionUser.getData().addUser(user);
            SessionUser.createUserSession(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // configuracao para a sessao expirar em 30 min
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", name);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            response.sendRedirect("index.jsp");

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/login.jsp");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

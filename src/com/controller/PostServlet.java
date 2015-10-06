package com.controller;

import com.model.post.Post;
import com.model.user.SessionUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String post = request.getParameter("textArea");
        if (post != null && !post.isEmpty()) {
            Post p = new Post(SessionUser.getUserId(), post);
            SessionUser.getData().addPost(p);
            SessionUser.updatePost();
            response.sendRedirect("index.html");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/index.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

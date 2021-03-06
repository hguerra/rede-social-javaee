package com.controller;

import com.google.gson.Gson;
import com.model.post.Post;
import com.model.user.SessionUser;
import com.model.util.SearchWord;
import com.model.util.WebUtil;
import javafx.geometry.Pos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        Post post = new Gson().fromJson(json, Post.class);
        if (post != null) {
            post.setTitle();
            post.setIdUser();
            SessionUser.getData().addPost(post);
            SessionUser.updatePost();
            String feed = new Gson().toJson(post);
            SearchWord.hashtag(post.getMensagem());
            Callback.onSuccess(response, feed);
        } else {
            Callback.onError(response);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package com.controller;

import com.google.gson.Gson;
import com.model.post.Post;
import com.model.user.SessionUser;
import com.model.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by heitor on 06/10/15.
 */
@WebServlet("/facebook")
public class FacebookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        System.out.println(json);
//        if (post != null) {
//            System.out.println(SessionUser.getData().removePost(post.getTitulo()));
//            SessionUser.updatePost();
//            Callback.onSuccess(response);
//        } else {
//            Callback.onError(response);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher(
//                    "/index.jsp");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

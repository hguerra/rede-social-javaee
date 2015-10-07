package com.controller;

import com.google.gson.Gson;
import com.model.post.Post;
import com.model.user.PersonData;
import com.model.user.SessionUser;
import com.model.user.User;
import com.model.util.SearchWord;
import com.model.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by heitor on 07/10/15.
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        User user = new Gson().fromJson(json, User.class);
        if (user != null) {
            User temp = SessionUser.getData().searchUser(user.getId());
            SessionUser.getData().updateUser(temp.getName(), user.getName(), temp.getAccessName(), user.getPassword(), user.getEmail(), user.getImage());
            PersonData p = new PersonData(user.getId(), user.getName(), user.getImage());
            Callback.onSuccess(response, new Gson().toJson(p));
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

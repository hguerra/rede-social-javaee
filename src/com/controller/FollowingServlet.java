package com.controller;

import com.google.gson.Gson;
import com.model.post.Post;
import com.model.user.PersonData;
import com.model.user.SessionUser;
import com.model.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by heitor on 06/10/15.
 */
@WebServlet("/following")
public class FollowingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        PersonData p = new Gson().fromJson(json, PersonData.class);
        if (p != null) {
            List<PersonData> f = SessionUser.getFollowings();
            for(PersonData i: f){
                if(i.getId().equals(p.getId())){
                   SessionUser.getData().removeFollowing(i.getId());
                }
            }
            Callback.onSuccess(response);
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
package com.controller;

import com.google.gson.Gson;
import com.model.data.Login;
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
import java.util.List;

/**
 * Created by heitor on 07/10/15.
 */
@WebServlet("/buscarusuario")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        Login log = new Gson().fromJson(json, Login.class);
        if (log != null) {
            List<PersonData> list = SessionUser.getData().searchUserPersonData(log.getUser());
            if (!list.isEmpty()) {
                Callback.onSuccess(response, new Gson().toJson(list));
            }
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

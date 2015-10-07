package com.controller;

import com.google.gson.Gson;
import com.model.facebook.Face;
import com.model.facebook.PostFacebook;
import com.model.twitter.GetTwitterStatus;
import com.model.twitter.Tweet;
import com.model.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by heitor on 06/10/15.
 */
@WebServlet("/facebook")
public class FacebookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        Face f = new Gson().fromJson(json, Face.class);
        if (f != null) {
            PostFacebook p = new PostFacebook();
            try {
                p.postFacebook(f.getPublicar());
                Callback.onSuccess(response);
            } catch (Exception e) {
                Callback.onError(response);
            }
        } else {
            Callback.onError(response);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PostFacebook p = new PostFacebook();
            Map<String, String> map = p.postFacebookExtractorMap("1425253217799171", 25);
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("\n");
                stringBuffer.append(entry.getValue());
            }
            Face t = new Face(stringBuffer.toString(), null);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(t));
        } catch (Exception e) {
            Callback.onError(response);
        }
    }
}

package com.controller;

import com.google.gson.Gson;
import com.model.post.Post;
import com.model.twitter.DoTweet;
import com.model.twitter.GetTwitterStatus;
import com.model.twitter.SimpleTweet;
import com.model.twitter.Tweet;
import com.model.user.SessionUser;
import com.model.user.UserAttributes;
import com.model.util.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by heitor on 06/10/15.
 */
@WebServlet("/tweet")
public class TweetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = WebUtil.requestJson(request);
        Tweet t = new Gson().fromJson(json, Tweet.class);
        if (t != null) {
            SimpleTweet tweet = new SimpleTweet();
            if (t.getImagem() != null)
                tweet.tweet(t.getTweet(), "image", t.getImagem());
            else
                tweet.tweet(t.getTweet());
            Callback.onSuccess(response, new Gson().toJson(t));
        } else {
            Callback.onError(response);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetTwitterStatus st = new GetTwitterStatus();
        Tweet t = new Tweet(st.getUserStatus(), null);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(t));
    }
}

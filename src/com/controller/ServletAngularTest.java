package com.controller;

import com.google.gson.Gson;
import com.model.PersonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by heitor on 30/09/15.
 */
@WebServlet("/recebe")
public class ServletAngularTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonData personData = new PersonData("Heitor", "Carneiro");
        String json = new Gson().toJson(personData);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}

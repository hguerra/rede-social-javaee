package com.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by heitor on 02/10/15.
 */
public class Callback {
    public static void onSuccess(HttpServletResponse response) {
        String success = "{ \"success\": true }";
        try {
            response.getWriter().write(success);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void onError(HttpServletResponse response) {
        String error = "{ \"success\": false }";
        try {
            response.getWriter().write(error);
            response.setStatus(400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

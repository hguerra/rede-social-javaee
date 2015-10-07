package com.model.util;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.BufferedReader;
import java.net.URL;

/**
 * Created by heitor on 02/10/15.
 */
public class WebUtil {
    public static String requestJson(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

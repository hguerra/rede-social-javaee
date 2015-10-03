package com.model.util;

import java.awt.*;
import java.net.URL;

/**
 * Created by heitor on 02/10/15.
 */
public class ConfigApp {
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

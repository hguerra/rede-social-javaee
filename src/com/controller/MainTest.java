package com.controller;

import com.google.gson.Gson;
import com.model.PersonData;

/**
 * Created by heitor on 30/09/15.
 */
public class MainTest {
    public static void main(String[] args) {
        PersonData p = new PersonData("Heitor", "Carneiro");
        String json = new Gson().toJson(p, PersonData.class);
        System.out.println(json);
    }
}

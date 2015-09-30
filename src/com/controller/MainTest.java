package com.controller;

import com.model.PersonData;

/**
 * Created by heitor on 30/09/15.
 */
public class MainTest {
    public static void main(String[] args) {
        PersonData p = new PersonData("Heitor", "Carneiro");
        System.out.println(p.getFirstName());
    }
}

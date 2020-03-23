package ru.eldorado;

import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        ClassPeriod classPeriod = new ClassPeriod();
        classPeriod.openWebsite();
        try {
            classPeriod.mainMethodTest();
        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }
        classPeriod.closeDriver();
    }
}

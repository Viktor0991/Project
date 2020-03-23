package ru.eldorado;

import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        ClassPeriod classPeriod = new ClassPeriod();
        classPeriod.setup();
        try {
            classPeriod.sait();
        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }
}

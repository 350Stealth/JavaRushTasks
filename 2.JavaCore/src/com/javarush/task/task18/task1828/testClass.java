package com.javarush.task.task18.task1828;

public class testClass {
    public static void main(String[] args) {
        int speed = 72;
        int aileron = 0;
        int flap = 30;
        int angle = 12;
        int fin = 0;
        String height = "13.1";
        String line = String.format("D:\\Projects\\Tantal\\BPLA\\334model\\CFD\\Results\\Test A7 high-lift wing plane\\Images\\Vel %d flap %d ailer %d angle %d heigh %s\\Volume Pressure iso2.png", speed, flap, aileron, angle, height);
        System.out.println(line);
    }
}

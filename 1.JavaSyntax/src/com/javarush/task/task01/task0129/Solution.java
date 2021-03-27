package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/

public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
        printCircleLength(15);
        if (args.length != 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Nothing to print");
        }
    }

    public static void printCircleLength(int radius) {
        //напишите тут ваш код
        double Pi = 3.14;
        double L = 2 * Pi * radius;
        System.out.println(L);
    }
}
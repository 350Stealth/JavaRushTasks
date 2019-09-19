package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            StackTraceElement[] elements = e.getStackTrace();
            System.out.println(elements.length);
            e.printStackTrace();
        }
    }
    
    public static void divideByZero() throws ArithmeticException {
        int a = 15/0;
        System.out.println(a);
    }
}

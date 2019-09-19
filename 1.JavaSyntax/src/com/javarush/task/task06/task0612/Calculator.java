package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }
    
    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }
    
    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }
    
    public static double division(int a, int b) {
        //напишите тут ваш код
        double res = (a * 1.0) / b;
        return res;
    }
    
    public static double percent(int a, int b) {
        //напишите тут ваш код
        double res = (a * 1.0) / 100.0 * b;
        return res;
    }
    
    public static void main(String[] args) {
       /*
        System.out.println(Calculator.plus(5, 6));
        System.out.println(Calculator.minus(5, 6));
        System.out.println(Calculator.multiply(5, 6));
        System.out.println(Calculator.division(5, 6));
        System.out.println(Calculator.percent(5, 6));
        */
    }
}
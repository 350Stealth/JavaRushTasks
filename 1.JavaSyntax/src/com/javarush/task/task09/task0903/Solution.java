package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        method2();
        
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(stackTraceElements[2].getLineNumber());
        int line = stackTraceElements[2].getLineNumber();
        return  /*напишите тут ваш код*/ line;
    }

    public static int method2() {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(stackTraceElements[2].getLineNumber());
        int line = stackTraceElements[2].getLineNumber();
        return  /*напишите тут ваш код*/ line;
    }

    public static int method3() {
        method4();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(stackTraceElements[2].getLineNumber());
        int line = stackTraceElements[2].getLineNumber();
        return  /*напишите тут ваш код*/ line;
    }

    public static int method4() {
        method5();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(stackTraceElements[2].getLineNumber());
        int line = stackTraceElements[2].getLineNumber();
        return  /*напишите тут ваш код*/ line;
    }

    public static int method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(stackTraceElements[2].getLineNumber());
        int line = stackTraceElements[2].getLineNumber();
        return  /*напишите тут ваш код*/ line;
    }
}

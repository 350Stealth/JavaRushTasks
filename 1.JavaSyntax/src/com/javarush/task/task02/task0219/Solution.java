package com.javarush.task.task02.task0219;

/* 
Печатаем трижды
*/

public class Solution {
    public static void print3(String text) {
        //напишите тут ваш код
        System.out.println(text + " " + text + " " + text);
        System.out.printf("%s %s %s\n", text, text, text);
    }

    public static void main(String[] args) {
        print3("window");
        print3("file");
    }
}

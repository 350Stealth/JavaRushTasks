package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код
    public static int convertToSeconds(int hour) {
        int seconds = hour * 60 * 60;
        return seconds;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        int seconds;
        seconds = convertToSeconds(12);
        System.out.println(seconds);
        seconds = convertToSeconds(15);
        System.out.println(seconds);
    }
}

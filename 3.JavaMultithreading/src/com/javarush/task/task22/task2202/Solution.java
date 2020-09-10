package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//        System.out.println(getPartOfString("the index of the first occurrence of the specified substring, or -1 if there is no such occurrence."));
//        System.out.println(getPartOfString("the index of the first"));
//        System.out.println(getPartOfString("the index of the"));
//        System.out.println(getPartOfString("JavaRush"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if (firstSpace < 0) throw new TooShortStringException();
        int secondSpace = 0;
        String line = string;
        for (int i = 0; i < 5; i++) {
            int index = line.indexOf(" ");
            if (index < 0 && i != 4) throw new TooShortStringException();
            if (index < 0 && i == 4) {
                index = line.length();
            } else {
                line = line.substring(index + 1);
            }
            secondSpace = secondSpace + index + 1;
        }
        line = string.substring(firstSpace + 1, secondSpace - 1);
        return line;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}

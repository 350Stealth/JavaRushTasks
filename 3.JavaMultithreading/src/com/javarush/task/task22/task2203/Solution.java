package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();
        int firstSpace = string.indexOf("\t");
        if (firstSpace < 0) throw new TooShortStringException();
        String line = string.substring(firstSpace + 1);
        int secondSpace = line.indexOf("\t");
        if (secondSpace < 0) throw new TooShortStringException();
        secondSpace = secondSpace + firstSpace + 1;
        line = string.substring(firstSpace + 1, secondSpace);
        return line;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java\t"));
        System.out.println(getPartOfString("JavaRush - лучший \tсервис обучения Java"));
    }
}

package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        
        testString.printSomething();
        
        String result = outputStream.toString();
        
        System.setOut(consolStream);
    
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(result);
        if (m.find( )) {
//            System.out.println(m.group(0));
//            System.out.println(m.group(1));
            System.out.println(m.group());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

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
        
        String[] nums = new String[2];
        int i = 0;
        Pattern patternNums = Pattern.compile("\\d"); //(\d+)\s([(+)(-)(\*)])\s(\d+)
        Matcher m = patternNums.matcher(result);
        while (m.find( )) {
//            System.out.println(m.group(0));
//            System.out.println(m.group(1));
//            System.out.println(m.group());
            nums[i] = m.group();
        }
        
        Pattern patternSymbol = Pattern.compile("\\*");
        Matcher mSym = patternSymbol.matcher(result);
        String symbol = "";
        if (m.find()) {
            symbol = m.group();
        }
        
        int answer = 0;
        
        switch (symbol) {
            case "+":
                answer = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
                break;
            case "-":
                answer = Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);
                break;
            case "*":
                answer = Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                break;
        }
    
        System.out.println(String.format("%s %s %s = %d", nums[0], symbol, nums[1], answer));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();
    
    public static void main(String[] args) {
        String advertise = "JavaRush - курсы Java онлайн";
        
        PrintStream concoleStream = System.out; //default stream
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        PrintStream stream = new PrintStream(outputStream);
        
        System.setOut(stream);
        
        testString.printSomething();
        
        System.setOut(concoleStream);
        
        String input = outputStream.toString();
        
        boolean flag = false;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            if (flag) {
                System.out.println(advertise);
            }
            flag = !flag;
        }
        scanner.close();
    }
    
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    
    public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String fileName = scanner.readLine();
        scanner.close();
        
        PrintStream consolOutput = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        
        System.setOut(stream);
        
        testString.printSomething();
        
        System.setOut(consolOutput);
        
        String result = outputStream.toString();
        
        System.out.println(result);
        
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(outputStream.toByteArray());
        fileOutputStream.close();
    }
    
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


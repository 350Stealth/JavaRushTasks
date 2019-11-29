package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream concoleStream = System.out; // default stream
        
        
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

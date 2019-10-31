package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        
        args[0] = "//home//stealth//IdeaProjects//JavaRushTasks//2.JavaCore//src//com//javarush//task//task18//task1816//in.txt";
    
        FileInputStream stream = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(stream);
        
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int count = 0;
        while (scanner.hasNextByte()) {
            String newChar = Byte.toString(scanner.nextByte());
            if (alphabet.contains(newChar)) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
        stream.close();
    }
}

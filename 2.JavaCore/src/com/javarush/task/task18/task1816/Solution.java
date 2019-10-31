package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        args = new String[1];
        args[0] = "//home//stealth//IdeaProjects//JavaRushTasks//2.JavaCore//src//com//javarush//task//task18//task1816//in.txt";
        
        FileInputStream stream = new FileInputStream(args[0]);
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int count = 0;
        while (stream.available() > 0) {
            char[] newChar = Character.toChars(stream.read());
            String line = newChar.toString();
            if (alphabet.contains(line)) {
                count++;
            }
        }

//        Character ch = Character.isAlphabetic(count);
        
        System.out.println(count);
//        scanner.close();
        stream.close();
    }
}

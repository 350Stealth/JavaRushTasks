package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        FileInputStream stream = new FileInputStream(args[0]);
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int count = 0;
        while (stream.available() > 0) {
            char[] newChar = Character.toChars(stream.read());
            String line = new String(newChar);
            if (alphabet.contains(line)) {
                count++;
            }
        }

        System.out.println(count);
        stream.close();
    }
}

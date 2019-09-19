package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        
        //напишите тут ваш код
        char[] chars = string.toCharArray();
        Set<Integer> spaces = new HashSet<>();
        
        int indexOfSpace = 0;
        
        while (string.indexOf(" ", indexOfSpace) != string.lastIndexOf(" ")) {
            spaces.add(string.indexOf(" ", indexOfSpace));
            indexOfSpace = string.indexOf(" ", indexOfSpace+1);
        }
        
        spaces.add(string.lastIndexOf(" "));
        String upperCaseChar = new String();
        String result = new String();
        
        for (int indexOS : spaces
        ) {
            upperCaseChar = string.substring(indexOS + 1, indexOS + 2);
            upperCaseChar = upperCaseChar.toUpperCase();
            result = string.substring(0, indexOS) + upperCaseChar + string.substring(indexOS + 2, string.length());
            string.replaceAll(string, result);
        }
    
        System.out.println(string);
    }
}

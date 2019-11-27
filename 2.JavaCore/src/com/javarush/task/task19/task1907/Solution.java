package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        String line;
        int count = 0;
        String pattern = ".*\\bworld\\b.*";
        /*  while (scanner.hasNext()) {
            line = scanner.next();
            if (line.matches(".*\\bworld\\b.*")) { //"[^[0-9A-z]]?[Ww]orld[^[0-9A-z]]?" ".*[Ww]orld.*" "(\\b|^)[Ww]orld(\\b|$)"
                // (\W?[Ww]orld\W?)|(\W?[Ww]orld\W.*)
                count++;
                System.out.println("+ " + line);
            } else {
                System.out.println(line);
            }
        }*/
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
            System.out.println(line);
            
            while (line.matches(pattern)) {
                count++;
                line = line.replaceFirst(pattern, "");
            }
    
            System.out.println(line);
        }
        scanner.close();
        fileReader.close();
        System.out.println(count);
    }
}

package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
    
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String testLineIn = scanner.readLine();
        String testLineOut =scanner.readLine();
        scanner.close();
        
        ////
//        String testLineIn = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/in.txt";
//        String testLineOut = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/out.txt";
        ////
    
    
        FileReader fileReader = new FileReader(testLineIn);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        char[] buff = new char[1];
        while (reader.ready()){
            reader.read(buff);
            reader.readLine();
            String symbol = new String(buff);
            if (symbol.matches("[\\d\\s]")) {
                line = line + symbol;
            }
        }
        
        reader.close();
        fileReader.close();
    
        FileWriter writer = new FileWriter(testLineOut);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(line);
        bufferedWriter.close();
        writer.close();
    }
}

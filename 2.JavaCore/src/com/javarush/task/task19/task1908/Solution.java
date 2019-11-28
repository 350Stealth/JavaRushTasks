package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
    
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String testLineIn = bufferedReader.readLine();
        String testLineOut =bufferedReader.readLine();
        bufferedReader.close();
        
        ////
//        String testLineIn = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/in.txt";
//        String testLineOut = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1908/out.txt";
//        String testLineIn = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\in2.txt";
//        String testLineOut = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\out.txt";
        ////
    
    
        FileReader fileReader = new FileReader(testLineIn);
        BufferedReader reader = new BufferedReader(fileReader);
        Scanner scanner;
        String line = "";
        while (reader.ready()){
            String nextLine = reader.readLine();
            scanner = new Scanner(nextLine);
            while (scanner.hasNext()) {
                String symbol = scanner.next();//new String(buff);
                if (symbol.matches("\\d+\\s?")) {
                    line = line + symbol + " ";
                }
            }
        }
        
        reader.close();
        fileReader.close();
    
        FileWriter writer = new FileWriter(testLineOut);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(line);
//        System.out.println(line);
        bufferedWriter.close();
        writer.close();
    }
}

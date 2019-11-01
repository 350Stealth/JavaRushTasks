package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        
        args =new String[1];
//        args[0] = "/home//stealth//IdeaProjects//JavaRushTasks//2.JavaCore//src//com//javarush//task//task18//task1817//in.txt";
        args[0] = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1817\\in.txt";
    
        FileInputStream inputStream = new FileInputStream(args[0]);
        int fullCount = 0;
        int spaceCount = 0;
        while (inputStream.available() > 0){
            int buff = inputStream.read();
            fullCount++;
            if (Character.isWhitespace(buff)) {
                spaceCount++;
            }
        }
    
        System.out.printf("FullCount: %d %nSpaceCount: %d%n", fullCount, spaceCount);
        System.out.printf("Count: %f", fullCount*1.0/spaceCount);
    }
}

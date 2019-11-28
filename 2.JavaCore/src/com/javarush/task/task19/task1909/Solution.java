package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
    
        ////
//        String testLineIn = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1909/in.txt";
//        String testLineOut = "/home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1909/out.txt";
//        String testLineIn = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1909\\in.txt";
//        String testLineOut = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1909\\out.txt";
        ////
    
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String testLineIn = inputReader.readLine();
        String testLineOut = inputReader.readLine();
        inputReader.close();
    
        FileReader fileReader = new FileReader(testLineIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(testLineOut);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (bufferedReader.ready()) {
            String buffer = bufferedReader.readLine();
            buffer = buffer.replaceAll("\\.", "!");
            bufferedWriter.write(buffer);
            bufferedWriter.write(System.lineSeparator());
        }
        bufferedWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}

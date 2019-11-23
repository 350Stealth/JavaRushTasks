package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
    
        FileReader fileReader = new FileReader(fileIn);
        FileWriter fileWriter = new FileWriter(fileOut);
        while (fileReader.ready()) {
            fileReader.read();
            fileWriter.write(fileReader.read());
        }
        fileReader.close();
        fileWriter.close();
    }
}

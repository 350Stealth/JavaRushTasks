package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
         //input data
        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
        
        args = new String[] {"span"};
        
        String regexpression = String.format("<%s>.*?</%s>", args[0], args[0]);
        System.out.println(regexpression);
        String textFromFile = "";
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            textFromFile += scanner.next();
        }
        scanner.close();
        String[] strArray = textFromFile.split(String.format("<%s>*?</%s>", args[0], args[0]));
    
        System.out.println(textFromFile);
        for (String item: strArray) {
            System.out.println(item);
        }
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
    
    }
}

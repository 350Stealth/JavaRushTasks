package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
         //input data
//        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";
        
        args = new String[] {"span"};
        
        String regexpression = String.format("(<%s>)*?(</%s>)", args[0], args[0]);
        System.out.println(regexpression);
        String textFromFile = "";
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            textFromFile += scanner.next();
        }
        scanner.close();
    
        Pattern pattern = Pattern.compile(regexpression);
    
        System.out.println(pattern.pattern());
        
//        String[] strArray = textFromFile.split(regexpression);
        String[] strArray = pattern.split(textFromFile.subSequence(0, textFromFile.length()));
//        List<String> strArrList = new ArrayList<>();
        
//        while (textFromFile.matches(regexpression)) {
//            strArrList.add(textFromFile.);
//        }
        
        System.out.println(textFromFile);
        for (String item: strArray) {
            System.out.println(item);
        }
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
    
    }
}

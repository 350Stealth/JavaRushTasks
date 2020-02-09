package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
<<<<<<< Updated upstream
         //input data
        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
//        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";
=======
        //input data
//        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";
>>>>>>> Stashed changes
        
        args = new String[]{"span"};
        
        String regexpression = String.format("(<%s.*?>).*?(</%s>)", args[0], args[0]);
        System.out.println(regexpression);
        StringBuilder textFromFile = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            textFromFile.append(scanner.next());
        }
        scanner.close();
<<<<<<< Updated upstream

        List<String> strArrList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexpression);
        Matcher mText = pattern.matcher(textFromFile.toString());
        while (mText.find()) {
            strArrList.add(mText.group());
        }
        
        System.out.println(textFromFile);
        for (String item: strArrList) {
=======
        
        Pattern pattern = Pattern.compile(regexpression);
        
        System.out.println(pattern.pattern());

//        String[] strArray = textFromFile.split(regexpression);
        String[] strArray = pattern.split(textFromFile.subSequence(0, textFromFile.length()));
//        List<String> strArrList = new ArrayList<>();

//        while (textFromFile.matches(regexpression)) {
//            strArrList.add(textFromFile.);
//        }
        
        System.out.println(textFromFile);
        for (String item : strArray) {
>>>>>>> Stashed changes
            System.out.println(item);
        }
    }
}
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
         //input data
        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
//        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";

        args = new String[]{"span"};
        
//        String regexpressionStart = String.format("(<%s.*?>).*?(</%s>)", args[0], args[0]);
        String regexpressionStart = String.format("(<%s.*?>)", args[0]);
        String regexpressionEnd = String.format("(</%s>)", args[0]);
        System.out.println(regexpressionStart);
        System.out.println(regexpressionEnd);
        StringBuilder textFromFile = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            textFromFile.append(scanner.next());
        }
        scanner.close();

        List<String> strArrList = new ArrayList<>();
        List<Integer> intArrStart = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexpressionStart);
        Matcher mText = pattern.matcher(textFromFile.toString());
        while (mText.find()) {
            strArrList.add(mText.group());
            intArrStart.add(mText.start());
        }
        
        List<String> strArrListEnd = new ArrayList<>();
        List<Integer> intArrEnd = new ArrayList<>();
        Pattern patternEnd = Pattern.compile(regexpressionEnd);
        Matcher mTextEnd = patternEnd.matcher(textFromFile.toString());
        while (mTextEnd.find()) {
            strArrListEnd.add(mTextEnd.group());
            intArrEnd.add(mTextEnd.start());
        }
        
        System.out.println(pattern.pattern());

        System.out.println(textFromFile);
        for (String item : strArrList) {
            System.out.println(item);
        }
        for (Integer item: intArrStart) {
            System.out.println(item);
        }
    
        System.out.println("--------");
    
        for (String item: strArrListEnd) {
            System.out.println(item);
        }
        for (Integer item: intArrEnd) {
            System.out.println(item);
        }
        
        String line = textFromFile.substring(intArrEnd.get(3), intArrEnd.get(3) + 7);
        System.out.println(line);
        
        List<String> setOfTags = new ArrayList<>();
        int startIndex = 0, endIndex = 0;
        while (true) {
            int startPos = intArrStart.get(startIndex);
            int endPos = intArrEnd.get(endIndex) + 7;
            if (startPos > endPos) {
                endIndex++;
                continue;                               //check for free ends
            }
            while (startPos > endPos || (startIndex + 1) < intArrStart.size()) {
            
            }
//            while (startPos)
            break;
        }
    }
}
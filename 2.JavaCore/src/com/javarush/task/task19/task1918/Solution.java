package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
        //input data
//        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
//        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";

//        args = new String[]{"span"};
        
        String regexpressionStart = String.format("<(%s+)\\s*[^>]*>", args[0]);
        String regexpressionEnd = String.format("</(%s+)>", args[0]);
        
        StringBuilder textFromFile = new StringBuilder();
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        char[] cbuf = new char[1];
        while (reader.ready()) {
            reader.read(cbuf);
            textFromFile.append(cbuf);
        }
        reader.close();
        
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
        
        List<String> setOfTags = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        
        indexList.addAll(intArrStart);
        indexList.addAll(intArrEnd);
        
        Integer[] indexArray = new Integer[indexList.size()];
        indexList.toArray(indexArray);
        Arrays.sort(indexArray);
        indexList.clear();
        
        for (int i = 0; i < indexArray.length; i++) {
            indexList.add(indexArray[i]);
        }
        
        int startIndex, endIndex;
        
        int i = 0, j = 0, k = 0;
        while (i < indexList.size()) {
            if (intArrStart.contains(indexList.get(i))) {
                startIndex = indexList.get(i);
            } else {
                i++;
                j = i;
                continue;
            }
            k++;
            while (k != 0 && j + 1 < indexList.size()) {
                j++;
                if (intArrEnd.contains(indexList.get(j))) {
                    k--;
                } else {
                    k++;
                }
                if (k == 0) {
                    endIndex = indexList.get(j) + args[0].length() + 3;
                    setOfTags.add(textFromFile.substring(startIndex, endIndex));
                }
            }
            i++;
            j = i;
        }
        
        for (String item : setOfTags) {
            System.out.println(item);
        }
    }
}
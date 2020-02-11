package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
         //input data
//        String fileName = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\in.txt";
        String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/in.txt";

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
        /*for (String item : strArrList) {
            System.out.println(item);
        }*/
        for (Integer item: intArrStart) {
            System.out.println(item);
        }
    
        System.out.println("--------");
    
        /*for (String item: strArrListEnd) {
            System.out.println(item);
        }*/
        for (Integer item: intArrEnd) {
            System.out.println(item);
        }
        
        String line = textFromFile.substring(intArrEnd.get(3), intArrEnd.get(3) + 7);
        System.out.println(line);
        
        List<String> setOfTags = new ArrayList<>();
//        Map<Integer, String> indexMap = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
        int indexI = 0, indexJ = 0;
        boolean flagStart = true, flagEnd = true;
        /*while (flagStart || flagEnd) {
            if (intArrStart.get(indexI) < intArrEnd.get(indexJ)) {
//                indexMap.put(intArrStart.get(indexI), regexpressionStart);
                indexList.add(intArrStart.get(indexI));
                if (indexI + 1 < intArrStart.size()) {
                    indexI++;
                } else {
                    flagStart = false;
                }
            } else {
//                indexMap.put(intArrEnd.get(indexJ), regexpressionEnd);
                indexList.add(intArrEnd.get(indexJ));
                if (indexJ + 1 < intArrEnd.size()) {
                    indexJ++;
                } else {
                    flagEnd = false;
                }
            }
            if (indexI + 1 >= intArrStart.size()) {
                flagStart = false;
//                indexI--;
            }
            if (indexJ + 1 >= intArrEnd.size()) {
                flagEnd = false;
//                indexJ--;
            }
        }*/
        
        indexList.addAll(intArrStart);
        indexList.addAll(intArrEnd);
        
        Integer[] indexArray = new Integer[indexList.size()];
        indexList.toArray(indexArray);
        Arrays.sort(indexArray);
        indexList.clear();
//        Arrays.asList(indexList);
    
        for (int i = 0; i < indexArray.length; i++) {
            indexList.add(indexArray[i]);
        }
    
       /* for (Map.Entry<Integer, String> item: indexMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }*/
        for (Integer item: indexList) {
            System.out.println(item);
        }
        
        int startIndex = 0, endIndex = 0;
        
        /*while (!intArrStart.isEmpty() && !intArrEnd.isEmpty()) {
            int i = 0, j = 0, k = 0;
            startIndex = intArrStart.get(i);
            i++;
            do {
//                endIndex = intArrEnd.get(j);
                if (i < intArrStart.size()) {
                    if (intArrStart.get(i) < intArrEnd.get(j)) {
                        i++;
                        k++;
                    } else {
                        k--;
                    }
                }
            } while (k > 0 || j < intArrEnd.size());
            endIndex = intArrEnd.get(j) + 7;
            setOfTags.add(textFromFile.substring(startIndex, endIndex));
            intArrStart.remove(i);
            intArrEnd.remove(j);
        }*/
        int i = 0, j = 0, k = 0;
        while (i < indexList.size()) {
//            j = i + 1;
            if (intArrStart.contains(indexList.get(i))) {
                startIndex = indexList.get(i);
            } else {
                i++;
                continue;
            }
            k++;
            while (k != 0 && j + 1 < indexList.size()) {
                j++;
                if (intArrEnd.contains(indexList.get(j))){
                    k--;
                } else {
                    k++;
                }
                if (k == 0) {
                    endIndex = indexList.get(j) + 7;
                    setOfTags.add(textFromFile.substring(startIndex, endIndex));
                }
            }
            i++;
            j = i;
        }
    
        for (String item: setOfTags) {
            System.out.println(item);
        }
    }
}
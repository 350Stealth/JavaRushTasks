package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String fileName = scanner.nextLine();
        scanner.close();
        
        scanner = new Scanner(new FileReader(fileName));
        List<Word> stringList = new ArrayList<>();
        while (scanner.hasNext()) {
            stringList.add(new Word(scanner.next()));
        }
        scanner.close();
        //...
        boolean flag = false;
        while (!flag) {
        
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) new StringBuffer();
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        LinkedList<String> stringList = new LinkedList<>();
        stringList = (LinkedList<String>) Arrays.asList(words.clone());
        while (!flag) {
            while (stringList.iterator().hasNext()) {
                
            }
        }
        return result;
    }
    
    public static boolean isCharMatch(String first, String second) {
        String lastChar = "";
        if (first != null && second.length() > 0) {
            lastChar = first.substring(first.length() - 2);
            System.out.println(lastChar);
        }
        String firstChar = "";
        if (second != null && second.length() > 0) {
            firstChar = second.substring(0, 1);
            System.out.println(firstChar);
        }
        boolean res = false;
        if (lastChar.equalsIgnoreCase(firstChar)) {
            res = true;
        }
        return res;
    }
}

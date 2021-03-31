package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        
        /*String[] lines = getTokens("level22.lesson13.task01", ".");
        for (String item: lines) {
            System.out.println(item);
        }*/
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> stringList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            stringList.add(tokenizer.nextToken());
        }
        String[] strings = new String[stringList.size()];
        return stringList.toArray(strings);
    }
}

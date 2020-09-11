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
        List<String> stringList = new LinkedList<>();
        while (scanner.hasNext()) {
            stringList.add(scanner.next());
        }
        scanner.close();
        //...
        StringBuilder result = getLine(stringList.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        
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

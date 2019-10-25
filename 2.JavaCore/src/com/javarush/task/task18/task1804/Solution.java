package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream stream = new FileInputStream(fileName);
        Map<Integer, Integer> bites = new HashMap<>();
        int buff;
        while (stream.available() > 0) {
            buff = stream.read();
            if (bites.containsKey(buff)) {
                Integer newValue = bites.get(buff);
                bites.replace(buff, ++newValue);
            } else {
                bites.put(buff, 1);
            }
        }
        stream.close();
        
        int min = 0;
        for (Map.Entry<Integer, Integer> item : bites.entrySet()
        ) {
            if (min == 0) {
                min = item.getValue();
                continue;
            }
            if (min > item.getValue()) {
                min = item.getValue();
            }
        }
    
//        System.out.println(min); //should be delete
        
        for (Map.Entry<Integer, Integer> item : bites.entrySet()
        ) {
            if (item.getValue() == min) {
                System.out.print(item.getKey() + " ");
            }
        }
    }
}

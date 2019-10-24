package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream stream = new FileInputStream(fileName);
        Map<Integer, Integer> bites = new HashMap<>();
        int buff = 0;
        while (stream.available() > 0) {
            buff = stream.read();
            if (bites.containsKey(buff)) {
                Integer newValue = bites.get(buff);
                bites.replace(buff, ++newValue);
            } else {
                bites.put(buff, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> item : bites.entrySet()
        ) {
            if (max < item.getValue())
                max = item.getValue();
        }
        for (Map.Entry<Integer, Integer> item : bites.entrySet()
        ) {
            if (item.getValue() == max) {
                System.out.print(item.getKey() + " ");
            }
        }
    }
}

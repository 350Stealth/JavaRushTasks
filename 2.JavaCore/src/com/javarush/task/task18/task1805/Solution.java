package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream stream = new FileInputStream(fileName);
        Set<Integer> bites = new HashSet<>();
        while (stream.available() > 0) {
            bites.add(stream.read());
        }
        stream.close();
        
        Integer[] bitesArray = new Integer[bites.size()];
        bites.toArray(bitesArray);
        Arrays.sort(bitesArray);
    
        for (int i = 0; i < bitesArray.length; i++) {
            System.out.print(bitesArray[i] + " ");
        }
    }
}

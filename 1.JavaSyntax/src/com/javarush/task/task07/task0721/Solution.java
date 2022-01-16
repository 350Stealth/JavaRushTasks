package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int maximum;
        int minimum;
        
        //напишите тут ваш код
        int[] mainArray = getInts();
        maximum = mainArray[0];
        minimum = mainArray[0];
        for (int i = 1; i < mainArray.length; i++) {
            maximum = maximum < mainArray[i] ? mainArray[i] : maximum;
            minimum = minimum > mainArray[i] ? mainArray[i] : minimum;
        }
        
        System.out.print(maximum + " " + minimum);
        
    }
    
    //напишите тут ваш код
    public static int[] getInts() {
        int[] items = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < items.length; i++) {
            items[i] = scanner.nextInt();
        }
        scanner.close();
        
        return items;
    }
}

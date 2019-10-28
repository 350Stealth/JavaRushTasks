package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
    
        FileInputStream inputStream = new FileInputStream(fileName);
        int buff;
        int count = 0;
        while (inputStream.available() > 0) {
            buff = inputStream.read();
            if ((char) buff == ',') {
                count++;
            }
        }
        inputStream.close();
        System.out.println(count);
    }
}

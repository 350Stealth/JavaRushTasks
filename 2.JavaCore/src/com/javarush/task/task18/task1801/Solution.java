package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream stream = new FileInputStream(fileName);
        int max = 0;
        while (stream.available() > 0) {
            int buff = stream.read();
            if (buff > max) {
                max = buff;
            }
        }
        
        stream.close();
        System.out.println(max);
    }
}

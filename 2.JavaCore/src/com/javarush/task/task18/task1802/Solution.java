package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream stream = new FileInputStream(fileName);
        int min = 0;
        if (stream.available() > 0 ) min = stream.read();
        while (stream.available() > 0) {
            int buf = stream.read();
            if (buf < min)
                min = buf;
        }
        stream.close();
    
        System.out.println(min);
    }
}

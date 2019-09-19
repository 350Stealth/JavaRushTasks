package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader;
        String fileName = "";
        String buf;
        Scanner scanner;
        
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (fileName != "") {
            try {
                scanner = new Scanner(new FileInputStream(fileName));
                while (scanner.hasNext()) {
                    buf = scanner.nextLine();
                    System.out.println(buf);
                }
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
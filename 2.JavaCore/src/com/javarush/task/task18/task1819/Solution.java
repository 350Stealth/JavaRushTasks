package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
    
        Scanner scanner = new Scanner(System.in);
        String firstFile = scanner.nextLine();
        String secondFile = scanner.nextLine();
        scanner.close();
    
        FileInputStream stream1 = new FileInputStream(firstFile);
        FileInputStream stream2 = new FileInputStream(secondFile);
        byte[] buff1 = new byte[stream1.available()];
        stream1.read(buff1);
        byte[] buff2 = new byte[stream2.available()];
        stream2.read(buff2);
        stream1.close();
        stream2.close();
        FileOutputStream stream3 = new FileOutputStream(firstFile);
        stream3.write(buff2);
        stream3.write(buff1);
        stream3.close();
    }
}

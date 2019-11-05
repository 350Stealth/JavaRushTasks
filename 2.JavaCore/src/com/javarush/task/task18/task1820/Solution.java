package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String fileIn = scanner.nextLine();
        String fileOut = scanner.nextLine();
        scanner.close();
        
        scanner = new Scanner(new FileInputStream(fileIn)).useLocale(Locale.ENGLISH);
        FileWriter stream = new FileWriter(fileOut);
        Double buff;
        while (scanner.hasNextDouble()) {
            buff = scanner.nextDouble();
            Integer nextBuff = Math.round(buff.floatValue());
            stream.write(nextBuff.toString());
            String space = " ";
            stream.write(space);
        }
        stream.close();
        scanner.close();
    }
}

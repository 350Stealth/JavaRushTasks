package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileInput = scanner.nextLine();
        String fileOutput1 = scanner.nextLine();
        String fileOutput2 = scanner.nextLine();
        scanner.close();
        
        FileInputStream inputStream = new FileInputStream(fileInput);
        FileOutputStream outputStream1 = new FileOutputStream(fileOutput1);
        FileOutputStream outputStream2 = new FileOutputStream(fileOutput2);
        
        if (inputStream.available() > 0) {
            
            int len = inputStream.available() / 2;
            len = inputStream.available() / 2.0 > len ? len + 1 : len;
            byte[] buffer = new byte[len];
            int count = inputStream.read(buffer);
            
            outputStream1.write(buffer, 0, count);
            buffer = new byte[inputStream.available()];
            count = inputStream.read(buffer);
            
            outputStream2.write(buffer, 0, count);
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}

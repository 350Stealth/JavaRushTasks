package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileIn = scanner.nextLine();
        String fileOut = scanner.nextLine();
        
        FileInputStream inputStream = new FileInputStream(fileIn);
        FileOutputStream outputStream = new FileOutputStream(fileOut);
        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            byte[] bufferNew = new byte[count];
            for (int i = 0; i < count; i++) {
                bufferNew[i] = buffer[count - i - 1];
            }
            outputStream.write(bufferNew, 0, count);
        }
    
        outputStream.close();
        inputStream.close();
    }
}

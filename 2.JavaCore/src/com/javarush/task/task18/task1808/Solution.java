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
        FileOutputStream outputStream = new FileOutputStream(fileOutput1);
        
        if (inputStream.available() > 0) {
            System.out.println(inputStream.available()); //for delete
            
            int len = inputStream.available()/2;
            byte[] buffer = new byte[len];
            int count = inputStream.read(buffer);
            System.out.println(count); //for delete
            
            outputStream.write(buffer, 0, count);
            outputStream.close();
            outputStream = new FileOutputStream(fileOutput2);
            buffer = new byte[inputStream.available()];
            count = inputStream.read(buffer);
            System.out.println(count); //for delete
            
            outputStream.write(buffer, 0, count);
            outputStream.close();
            inputStream.close();
        }

//        System.out.println(15/2);
    }
}

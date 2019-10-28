package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        FileInputStream inputStream;
        while (true) {
            fileName = scanner.nextLine();
            inputStream = new FileInputStream(fileName);
            if (inputStream.available() < 1000) {
                scanner.close();
                inputStream.close();
                throw new DownloadException();
            }
            inputStream.close();
        }
    }
    
    public static class DownloadException extends Exception {
    
    }
}

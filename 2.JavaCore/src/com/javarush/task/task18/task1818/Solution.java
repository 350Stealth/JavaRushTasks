package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        scanner.close();
    
        FileInputStream inputStreamFile2 = new FileInputStream(file2);
        FileOutputStream outputStreamFile1 = new FileOutputStream(file1);
        if (inputStreamFile2.available() > 0) {
            byte[] buff = new byte[inputStreamFile2.available()];
            inputStreamFile2.read(buff);
            outputStreamFile1.write(buff);
        }
        inputStreamFile2.close();
        outputStreamFile1.close();
        
        FileOutputStream outputStream = new FileOutputStream(file1, true);
        FileInputStream inputStream = new FileInputStream(file3);
        if (inputStream.available() > 0) {
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff);
            outputStream.write(buff);
        }
        
        inputStream.close();
        outputStream.close();
    }
}

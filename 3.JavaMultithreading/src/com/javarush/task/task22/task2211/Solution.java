package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }
        String inputFileName = args[0];
        String outputFileName = args[1];
    
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = StandardCharsets.UTF_8;
        
        File fileName = new File(inputFileName);
        InputStream inputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String line = new String(buffer, windows1251);
        inputStream.close();
        
        fileName = new File(outputFileName);
        OutputStream outputStream = new FileOutputStream(fileName);
        buffer = line.getBytes(utf8);
        outputStream.write(buffer);
        outputStream.close();
    }
}

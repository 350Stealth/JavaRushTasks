package com.javarush.task.task18.task1825;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        TreeSet<String> filesSet = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String baseName = name.substring(0, name.lastIndexOf("."));
        filesSet.add(name);
        while (!name.equals("end")) {
            name = scanner.nextLine();
//            String subString = name.substring(0, name.lastIndexOf("."));
            if (!name.contains(baseName)) {
                continue;
            }
            filesSet.add(name);
        }
        scanner.close();
        
        /////
/*        for (String item : filesSet
        ) {
            System.out.println(item);
        }
        System.out.println(baseName);*/
        /////
        
        FileOutputStream outputStream = new FileOutputStream(baseName, true);
        for (String item: filesSet
             ) {
            FileInputStream inputStream = new FileInputStream(item);
            while (inputStream.available() > 0) {
                byte[] buff = new byte[inputStream.available()];
                int nextBuff = inputStream.read(buff);
                outputStream.write(buff);
            }
            inputStream.close();
        }
        outputStream.close();
    }
}

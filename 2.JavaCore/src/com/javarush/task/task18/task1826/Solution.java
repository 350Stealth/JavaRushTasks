package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        ////
//        args = new String[1];
//        args[0] = "-e /home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/in.txt /home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/out.txt";
//        args[0] = "-d /home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/out.txt /home/stealth/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1826/out2.txt";
        ////

//        System.out.println(args[0]); // for delete

//        Scanner scanner = new Scanner(args[0]);
        String key = args[0];//scanner.next();
        String fileIn = args[1];//scanner.next();
        String fileOut = args[2];//scanner.next();
        
        ////
//        System.out.println(key);
//        System.out.println(fileIn);
//        System.out.println(fileOut);

//        scanner.close();
        
        FileInputStream inputStream = new FileInputStream(fileIn);
        FileOutputStream outputStream = new FileOutputStream(fileOut);
//        System.out.println(inputStream.available()); // for delete
        switch (key) {
            case "-e":
                byte[] buff = new byte[inputStream.available()];
                int nextBuff = inputStream.read(buff);
                for (int i = buff.length - 1; i >= 0; i--) {
                    outputStream.write(buff[i]);
                }
                break;
            case "-d":
                byte[] buff2 = new byte[inputStream.available()];
                int nextBuff2 = inputStream.read(buff2);
                for (int i = buff2.length - 1; i >= 0; i--) {
                    outputStream.write(buff2[i]);
                }
                break;
        }
        inputStream.close();
        outputStream.close();
    }
    
}

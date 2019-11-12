package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        //for deleting
//        args = new String[]{"12"};
        //
        
        int id = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        FileInputStream inputStream = new FileInputStream(fileName);
        scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.split(" ");
            try {
                if (Integer.parseInt(strings[0]) == id) {
                    System.out.println(nextLine);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                scanner.close();
                inputStream.close();
            }
        }
        scanner.close();
        inputStream.close();
    }
}

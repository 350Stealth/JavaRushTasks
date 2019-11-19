package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
//        scanner = new Scanner(fileName);
        
        switch (args[0]) {
            case "-c":
                createData(fileName, args[1], args[2], args[3]);
                break;
            case "-r":
                readData(fileName);
                break;
            case "-u":
                updateData(fileName, args[1], args[2], args[3]);
                break;
            case "-d":
                deleteData(fileName, args[1], args[2], args[3]);
                break;
        }
        
    }
    
    public static void createData(String fileName, String productName, String price, String quantity) {
        Scanner scanner = new Scanner(fileName);
        int maxID = 0;
        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            int ID = Integer.parseInt(item.substring(0, 7));
            if (ID > maxID) {
                maxID = ID;
            }
        }
        scanner.close();
    }
    
    public static void readData(String fileName){
    
    }
    
    public static void updateData(String fileName, String productName, String price, String quantity) {
    
    }
    
    public static void deleteData(String fileName, String productName, String price, String quantity) {
    
    }
}

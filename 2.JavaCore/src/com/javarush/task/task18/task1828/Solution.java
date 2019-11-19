package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        /*////
        args = new String[4];
        args[0] = "-c";
        args[1] = "Шорты пляжные красные красивые с блестяшками и рюшечками";
        args[2] = "162.00";
        args[3] = "45";
        */
        
        args = new String[5];
        args[0] = "-u";
        args[1] = "198478";
        args[2] = "Шорты пляжные красные красивые с блестяшками и рюшечками";
        args[3] = "162.00";
        args[4] = "45";
        
        /*
        args = new String[2];
        args[0] = "-d";
        args[1] = "198478";
         */
        ////*/
//        System.out.println(args.length);
//        System.out.println(args == null);
        if (args != null && args.length != 0) {
            
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
                    updateData(fileName, args[1], args[2], args[3], args[4]);
                    break;
                case "-d":
                    deleteData(fileName, args[1], args[2], args[3]);
                    break;
            }
        }
    }
    
    public static void createData(String fileName, String productName, String price, String quantity) throws Exception {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int maxID = 0;
        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            int ID = Integer.parseInt(item.substring(0, 8).trim());
            if (ID > maxID) {
                maxID = ID;
            }
        }
        scanner.close();
        
        maxID++;
        String idLine = Integer.toString(maxID);
        idLine = fillBySpaces(8, idLine);
        productName = fillBySpaces(30, productName);
        price = fillBySpaces(8, price);
        quantity = fillBySpaces(4, quantity);
        
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("\n" + idLine + productName + price + quantity);
        writer.close();
    }
    
    public static void readData(String fileName) {
    
    }
    
    public static void updateData(String fileName, String id, String productName, String price, String quantity) throws Exception {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int lineID;
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int ID = Integer.parseInt(line.substring(0, 8).trim());
            if (ID == Integer.parseInt(id)) {
                String item = fillBySpaces(8, id) + fillBySpaces(30, productName) +
                    fillBySpaces(8, price) + fillBySpaces(4, quantity);
                lines.add(item);
            } else {
                lines.add(line);
            }
        }
        scanner.close();
        
        FileWriter writer = new FileWriter(fileName);
        for (String item : lines
        ) {
            writer.write(item);
            writer.write(System.lineSeparator());
        }
        writer.close();
    }
    
    public static void deleteData(String fileName, String productName, String price, String quantity) {
    
    }
    
    public static String fillBySpaces(int lineLength, String line) {
        if (line.length() > lineLength) {
            line = line.substring(0, lineLength);
        } else {
            while (line.length() < lineLength) {
                line = line + " ";
            }
        }
        System.out.println(line);
        System.out.println(line.length());
        return line;
    }
}

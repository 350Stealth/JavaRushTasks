package com.javarush.task.task17.task1721;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    
    public static void main(String[] args) throws CorruptedDataException{
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        
        scanner.close();
        try {
            scanner = new Scanner(new FileReader(firstName));
            while (scanner.hasNext()) {
                allLines.add(scanner.nextLine());
            }
            scanner.close();
            scanner = new Scanner(new FileReader(secondName));
            while (scanner.hasNext()) {
                forRemoveLines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Solution solution = new Solution();
        solution.joinData();
    }
    
    public void joinData() throws CorruptedDataException {
        
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            /*for (String line: allLines
            ) {
                System.out.println(line);
            }*/
        } else {
            allLines.clear();
//            System.out.println("CorruptedDataException");
//            System.out.println(allLines.size());
            throw new CorruptedDataException();
        }
        /*for (String line : forRemoveLines
        ) {
            if (allLines.containsAll())
        }*/
    }
}

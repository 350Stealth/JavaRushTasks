package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        
//        String fileIn = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\in.txt";
//        String fileOut = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\out.txt";
        
        String fileIn = args[0];
        String fileOut = args[1];
        
        boolean flag = false;
        String comma = ",";
        Scanner scanner = new Scanner(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() > 6) {
                if (flag) {
                    writer.write(comma);
                }
                writer.write(word);
                if (!flag) {
                    flag = true;
                }
            }
        }
        writer.close();
        scanner.close();
    }
}

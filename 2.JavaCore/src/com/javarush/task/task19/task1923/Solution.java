package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

//        String fileIn = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\in.txt";
        String fileIn = args[0];
//        String fileOut = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\out.txt";
        String fileOut = args[1];
        
        boolean flag = false;
        Scanner scanner = new Scanner(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.matches(".*\\d+.*")) {
                if (flag) {
                    writer.write(" ");
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

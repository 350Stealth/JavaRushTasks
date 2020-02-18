package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = bufferedReader.readLine();
        bufferedReader.close();
        
//        String fileIn = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1926\\in.txt";
    
        Scanner scanner = new Scanner(new FileReader(fileIn));
        while (scanner.hasNextLine()) {
            StringBuilder builder = new StringBuilder(scanner.nextLine());
            String line = builder.reverse().toString();
            System.out.println(line);
        }
        scanner.close();
    }
}

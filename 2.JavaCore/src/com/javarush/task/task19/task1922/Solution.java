package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
    
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1922\\in.txt";
//        String fileName = "/home/stealth/Projects/Java/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1922/in.txt";
    
        String regExpression = "\\s+";
//        Pattern pattern = Pattern.compile(regExpression);
        List<String> lines = new ArrayList<>();
    
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        fileReader.close();
    
        List<String> wordGroups = new ArrayList<>();
        for (String item: lines) {
            String[] splitString = item.split(regExpression);
            for (String word : splitString) {
                /*if (word.equals(words.get(0)) || word.equals(words.get(1)) || word.equals(words.get(2))) {
                    wordGroups.add(word);
                }*/
                for (String string : words) {
                    if (word.equals(string)) {
                        wordGroups.add(word);
                    }
                }
            }
            if (wordGroups.size() == 2) {
                System.out.println(item);
            }
            wordGroups.clear();
        }
    }
}

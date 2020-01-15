package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileIn_1 = consolReader.readLine();
//        String fileIn_2 = consolReader.readLine();
        consolReader.close();

//        String fileIn_1 = "e:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\in1.txt";
//        String fileIn_2 = "e:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\in2.txt";

//        String fileIn_1 = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\in1.txt";
//        String fileIn_2 = "d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\in2.txt";
        
        String fileIn_1 = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1916/in1.txt";
        String fileIn_2 = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1916/in2.txt";
    
        FileReader fileReader_1 = new FileReader(new File(fileIn_1));
        BufferedReader reader_1 = new BufferedReader(fileReader_1);
        FileReader fileReader_2 = new FileReader(new File(fileIn_2));
        BufferedReader reader_2 = new BufferedReader(fileReader_2);
    
        ArrayList<String> linesFromFF = new ArrayList<>();
        ArrayList<String> linesFromSF = new ArrayList<>();
    
        while (reader_1.ready()) {
            linesFromFF.add(reader_1.readLine());
        }
        
        while (reader_2.ready()) {
            linesFromSF.add(reader_2.readLine());
        }
    
        reader_2.close();
        reader_1.close();
        fileReader_2.close();
        fileReader_1.close();
    
        for (String item: linesFromFF) {
            System.out.println(item);
        }
        System.out.println();
        for (String item: linesFromSF) {
            System.out.println(item);
        }
        System.out.println();
        
        int i = 0;
        int j = 0;
        
        while (/*i < linesFromFF.size() && j < linesFromSF.size()*/true) {
            if (linesFromFF.get(i).equals(linesFromSF.get(j))) {
                lines.add(new LineItem(Type.SAME, linesFromFF.get(i)));
                if (i + 1 < linesFromFF.size()) i++;
                if (j + 1 < linesFromSF.size()) j++;
            } else if ((i + 1) < linesFromFF.size() && linesFromFF.get(i + 1).equals(linesFromSF.get(j))) {
                lines.add(new LineItem(Type.REMOVED, linesFromFF.get(i)));
                    i++;
            } else if ((j + 1) < linesFromSF.size() && linesFromSF.get(j + 1).equals(linesFromFF.get(i))) {
                lines.add(new LineItem(Type.ADDED, linesFromSF.get(j)));
                    j++;
            }
            if (i + 1 == linesFromFF.size() && j + 1 == linesFromSF.size()) {
                break;
            }
        }
    
        for (LineItem item: lines
             ) {
            System.out.printf("%s: %s", item.line, item.type);
            System.out.println();
        }
    }
    
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    
    public static class LineItem {
        public Type type;
        public String line;
        
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

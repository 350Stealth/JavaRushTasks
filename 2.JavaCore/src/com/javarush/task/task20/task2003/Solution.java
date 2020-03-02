package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/*
Знакомство с properties
*/
public class Solution {
    
    public static Map<String, String> properties = new HashMap<>();
    
    public /*static*/ void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.nextLine();
//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\config.property";
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\cursors.property";
        scanner.close();
        InputStream stream = new FileInputStream(fileName);
        try {
            load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stream.close();
    }
    
    public /*static*/ void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        boolean flag = false;
        for (Map.Entry<String, String> item : properties.entrySet()) {
            if (flag) {
                writer.newLine();
            } else {
                flag = true;
            }
            writer.write(String.format("%s = %s", item.getKey(), item.getValue()));
            writer.flush();
        }
        writer.close();*/
        Properties prop = new Properties();
        for (Map.Entry<String, String> item: properties.entrySet()) {
            prop.setProperty(item.getKey(), item.getValue());
        }
        prop.store(outputStream, "");
    }
    
    public /*static*/ void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        /*Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String keyLine = scanner.next();
            if (keyLine.contains("////") || keyLine.contains("#") || keyLine.contains("!") || keyLine.isEmpty()) {
                continue;
            }
            scanner.next();
            String valueLine = scanner.nextLine();
            properties.put(keyLine, valueLine);
        }
        scanner.close();*/
        Properties prop = new Properties();
        while (inputStream.available() > 0) {
            prop.load(inputStream);
        }
        Set<String> keys = prop.stringPropertyNames();
        for (String item: keys) {
            properties.put(item, prop.getProperty(item));
        }
    }
    
    public static void main(String[] args) throws IOException {
//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\config.properties";
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\out.txt";
        OutputStream outputStream = new FileOutputStream(fileName);
        try {
            solution.save(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

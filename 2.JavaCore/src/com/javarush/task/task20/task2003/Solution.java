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
        String fileName = scanner.nextLine();
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
        Properties prop = new Properties();
        for (Map.Entry<String, String> item: properties.entrySet()) {
            prop.setProperty(item.getKey(), item.getValue());
        }
        prop.store(outputStream, "");
    }
    
    public /*static*/ void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
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

    }
}

package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Знакомство с properties
*/
public class Solution {
    
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException{
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

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        boolean flag = false;
        for (Map.Entry<String, String> item: properties.entrySet()) {
            if (flag) {
                writer.newLine();
            } else {
                flag = true;
            }
            writer.write(String.format("%s = %s", item.getKey(), item.getValue()));
            writer.flush();
        }
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.close();
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        String fileName = args[0];
//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1920\\in.txt";
        
        Map<String, Double> salaryMap = new TreeMap<>();
        
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            Double sal = scanner.nextDouble();
            if (salaryMap.containsKey(name)) {
                Double num = salaryMap.get(name) + sal;
                salaryMap.replace(name, num);
            } else {
                salaryMap.put(name, sal);
            }
        }
        scanner.close();
        fileReader.close();
        
        List<Double> salaryList = Arrays.asList(salaryMap.values().toArray(new Double[salaryMap.size()]));
        Collections.sort(salaryList);
        
        Double salaryMax = salaryList.get(salaryList.size() - 1);
        
        for (Map.Entry<String, Double> item : salaryMap.entrySet()) {
            if (item.getValue().equals(salaryMax)) {
                System.out.println(item.getKey());
            }
        }
    }
}

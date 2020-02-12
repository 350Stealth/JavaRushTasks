package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        
        String fileName = args[0];
//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1919\\in.txt";
        Map<String, Double> salary = new HashMap<>();
    
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String name = scanner.next();
            Double sal = scanner.nextDouble();
            if (salary.containsKey(name)) {
                Double adding = salary.get(name) + sal;
                salary.replace(name, adding);
            } else {
                salary.put(name, sal);
            }
        }
        scanner.close();
        fileReader.close();
    
        List<String> keys = new ArrayList<>();
        keys.addAll(salary.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(String.format("%s %s", keys.get(i), salary.get(keys.get(i))));
        }
    }
}

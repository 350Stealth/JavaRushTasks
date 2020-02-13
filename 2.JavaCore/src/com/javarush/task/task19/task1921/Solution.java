package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    
    public static void main(String[] args) throws IOException {
    
        String fileName = args[0];
//        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1921\\in.txt";
    
        List<String> lines = new ArrayList<>();
    
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        fileReader.close();
        
        for (String item : lines) {
            String[] words = item.split("\\s");
            int wordSize = words.length;
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < wordSize - 3; i++) {
                if (i > 0) {
                    name.append(" ");
                }
                name.append(String.format("%s", words[i]));
            }
            name.toString().trim();
            int date1 = Integer.parseInt(words[wordSize - 3]); //day
            int date2 = Integer.parseInt(words[wordSize - 2]) - 1; //month
            int date3 = Integer.parseInt(words[wordSize - 1]) - 1900; //year
            Date dateObject = new Date(date3, date2, date1);
    
//            System.out.println(String.format("%s: %s", name, dateObject.toString()));
    
            PEOPLE.add(new Person(name.toString(), dateObject));
        }
    }
}

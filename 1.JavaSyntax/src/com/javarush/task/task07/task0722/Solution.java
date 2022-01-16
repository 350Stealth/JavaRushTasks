package com.javarush.task.task07.task0722;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        
        //напишите тут ваш код
        List<String> list = new ArrayList<>();
        String line;
        for (;;) {
            line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            list.add(line);
        }
        
        for (String item : list) {
            System.out.println(item);
        }
    }
}
package com.javarush.task.task03.task0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
План по захвату мира
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        
        int years = scanner.nextInt();
        String name = scanner.nextLine();
        
        scanner.close();
        
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        int years = Integer.parseInt(reader.readLine());
        String name = reader.readLine();
        
        reader.close();*/
    
        System.out.printf("%s захватит мир через %d лет. Му-ха-ха!", name, years);
    }
}

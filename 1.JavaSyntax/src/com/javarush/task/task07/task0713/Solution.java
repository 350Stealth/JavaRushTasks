package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> mainList = new ArrayList<>();
        ArrayList<Integer> div2List = new ArrayList<>();
        ArrayList<Integer> div3List = new ArrayList<>();
        ArrayList<Integer> listOfRest = new ArrayList<>();
    
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
//            mainList.add(scanner.nextInt());
            mainList.add(random.nextInt(100));
        }
        scanner.close();
        
        for (Integer item: mainList) {
            if (item % 2 == 0) div2List.add(item);
            if (item % 3 == 0) div3List.add(item);
            if (item % 2 != 0 && item % 3 != 0) listOfRest.add(item);
        }
        
        printList(div2List);
        System.out.println("===========");
        printList(div3List);
        System.out.println("===========");
        printList(listOfRest);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer item: list) {
            System.out.println(item);
        }
    }
}

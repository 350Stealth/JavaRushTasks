package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        /*if (args.length == 0) {
            System.out.println("There are no params"); // should be delete
            return;
        }*/
        String[] testArgs = new String[5];
        testArgs[0] = "-i"; testArgs[1] = "1";
//        testArgs[0] = "-d"; testArgs[1] = "1";
//        testArgs[0] = "-u"; testArgs[1] = "1"; testArgs[2] = "Djon Snow"; testArgs[3] = "м"; testArgs[4] = "15/04/1990";
//        testArgs[0] = "-c"; testArgs[1] = "Djon Snow"; testArgs[2] = "м"; testArgs[3] = "15/04/1990";
        switch (testArgs[0]) {
            case "-c":
                //create
                allPeople.add(Person.createMale(testArgs[1], ));
                break;
            case "-u":
                //update
                break;
            case "-d":
                //delete
                allPeople.remove(Integer.parseInt(testArgs[1]));
                break;
            case "-i":
                //info
                System.out.println(allPeople.get(Integer.parseInt(testArgs[1])));
                break;
        }
    }
}

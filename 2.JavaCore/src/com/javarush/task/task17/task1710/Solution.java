package com.javarush.task.task17.task1710;

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
        if (args.length == 0) {
            System.out.println("There are no params"); // should be delete
            return;
        }
        switch (args[0]) {
            case "-c":
                //create
                break;
            case "-u":
                //update
                break;
            case "-d":
                //delete
                allPeople.remove(Integer.parseInt(args[1]));
                break;
            case "-i":
                //info
                System.out.println(allPeople.get(Integer.parseInt(args[1])));
                break;
        }
    }
}

package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        SimpleDateFormat dateIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
//        SimpleDateFormat dateOut = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
//        args = new String[5];
//        args[0] = "-i"; args[1] = "1";
//        args[0] = "-d"; args[1] = "1";
//        args[0] = "-u"; args[1] = "1"; args[2] = "Djon Snow"; args[3] = "м"; args[4] = "15/04/1990";
//        args[0] = "-c"; args[1] = "Djon Snow"; args[2] = "ж"; args[3] = "15/04/1990";
        switch (args[0]) {
            case "-c":
                //create
                try {
                    switch (args[2]) {
                        case "м":
                            person = Person.createMale(args[1], dateIn.parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
//                            System.out.println(allPeople.get(allPeople.indexOf(person)));
                            break;
                        case "ж":
                            person = Person.createFemale(args[1], dateIn.parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
//                            System.out.println(allPeople.get(allPeople.indexOf(person)));
                            break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "-u":
                //update
                try {
                    int i = Integer.parseInt(args[1]);
                    allPeople.get(i).setName(args[2]);
                    switch (args[3]) {
                        case "м":
                            allPeople.get(i).setSex(Sex.MALE);
                            break;
                        case "ж":
                            allPeople.get(i).setSex(Sex.FEMALE);
                            break;
                    }
                    allPeople.get(i).setBirthDate(dateIn.parse(args[4]));
                    System.out.println(i);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "-d":
                //delete
                int i = Integer.parseInt(args[1]);
//                allPeople.remove(i);
                allPeople.get(i).setName(null);
                allPeople.get(i).setBirthDate(null);
                allPeople.get(i).setSex(null);
                System.out.println(i);
                break;
            case "-i":
                //info
                i = Integer.parseInt(args[1]);
                System.out.println(allPeople.get(i));
                break;
        }
    }
}

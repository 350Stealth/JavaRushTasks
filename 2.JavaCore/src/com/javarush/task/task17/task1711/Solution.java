package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
        
        int index;
        SimpleDateFormat dateIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
    
//        args = new String[5];
//        args = new String[3]; args[0] = "-i"; args[1] = "0"; args[2] = "1";
//        args = new String[3]; args[0] = "-d"; args[1] = "1"; args[2] = "0";
//        args = new String[9]; args[0] = "-u"; args[1] = "1"; args[2] = "Djon Snow"; args[3] = "м"; args[4] = "15/04/1990"; args[5] = "0"; args[6] = "Little girl"; args[7] = "ж"; args[8] = "20/09/2005";
//        args = new String[7]; args[0] = "-c"; args[1] = "Djon Snow"; args[2] = "ж"; args[3] = "15/04/1990"; args[4] = "Little girl"; args[5] = "ж"; args[6] = "20/09/2005";
        
        switch (args[0]) {
            case "-c":
                // create
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        try {
                            switch (args[i + 1]) {
                                case "м":
                                    person = Person.createMale(args[i], dateIn.parse(args[i + 2]));
                                    allPeople.add(person);
                                    System.out.println(allPeople.indexOf(person));
//                            System.out.println(allPeople.get(allPeople.indexOf(person)));
                                    break;
                                case "ж":
                                    person = Person.createFemale(args[i], dateIn.parse(args[i + 2]));
                                    allPeople.add(person);
                                    System.out.println(allPeople.indexOf(person));
//                            System.out.println(allPeople.get(allPeople.indexOf(person)));
                                    break;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "-u":
                // update
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        index = Integer.parseInt(args[i]);
                        try {
//                        int i = Integer.parseInt(args[1]);
                            allPeople.get(index).setName(args[i + 1]);
                            switch (args[i + 2]) {
                                case "м":
                                    allPeople.get(index).setSex(Sex.MALE);
                                    break;
                                case "ж":
                                    allPeople.get(index).setSex(Sex.FEMALE);
                                    break;
                            }
                            allPeople.get(index).setBirthDate(dateIn.parse(args[i + 3]));
                            System.out.println(index);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "-d":
                // delete
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setBirthDate(null);
                        allPeople.get(index).setSex(null);
                        System.out.println(index);
                    }
                }
                break;
            case "-i":
                // info
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        System.out.println(allPeople.get(index).toString());
                    }
                }
                break;
        }
    }
}

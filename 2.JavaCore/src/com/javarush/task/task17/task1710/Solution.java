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
        SimpleDateFormat dateIn = new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH);
//        SimpleDateFormat dateOut = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
//        String[] testArgs = new String[5];
//        testArgs[0] = "-i"; testArgs[1] = "1";
//        testArgs[0] = "-d"; testArgs[1] = "1";
//        testArgs[0] = "-u"; testArgs[1] = "1"; testArgs[2] = "Djon Snow"; testArgs[3] = "м"; testArgs[4] = "15/04/1990";
//        testArgs[0] = "-c"; testArgs[1] = "Djon Snow"; testArgs[2] = "ж"; testArgs[3] = "15/04/1990";
        switch (args[0]) {
            case "-c":
                //create
                try {
                    switch (args[2]) {
                        case "м":
                            allPeople.add(Person.createMale(args[1], dateIn.parse(args[3])));
                            break;
                        case "ж":
                            allPeople.add(Person.createFemale(args[1], dateIn.parse(args[3])));
                            break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
               /* for (Person person : allPeople
                ) {
                    System.out.println(person);
                }*/
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
//                allPeople.get(i).setSex(testArgs[3]);
                    allPeople.get(i).setBirthDate(dateIn.parse(args[4]));
//                    System.out.println(allPeople.get(i).toString()); //should be delete//
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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

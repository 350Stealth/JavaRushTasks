package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        /*////
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        
        scanner = new Scanner(new FileInputStream(fileName));
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        while (scanner.hasNext()) {
            Person person = personScannerAdapter.read();
            System.out.println(person);
        }
        personScannerAdapter.close();
        scanner.close();
        ////*/

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
    
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
    
        @Override
        public Person read() throws IOException {
            Person person;
            if (fileScanner.hasNext()) {
                try {
                    String line = fileScanner.nextLine();
                    Scanner scanner = new Scanner(line);
                    String lastName = scanner.next();
                    String firstName = scanner.next();
                    String midName = scanner.next();
                    String birthDateStr = scanner.nextLine();
                    scanner.close();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
                    Date birthDate = dateFormat.parse(birthDateStr);
                    person = new Person(firstName, midName, lastName, birthDate);
                    return person;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }
    
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

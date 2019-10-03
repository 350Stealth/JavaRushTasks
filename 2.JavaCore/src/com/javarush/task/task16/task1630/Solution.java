package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        Scanner scanner = new Scanner(System.in);
        firstFileName = scanner.nextLine();
        secondFileName = scanner.nextLine();
        scanner.close();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread implements ReadFileInterface {
        List<String> stringList = new ArrayList<>();
        String fileName = "";
        
        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }
    
        @Override
        public String getFileContent() {
            String fileContent ="";
            for (String s: stringList
                 ) {
                fileContent += (s + " ");
            }
            return fileContent.trim();
        }
    
        @Override
        public void join() throws InterruptedException {
        
        }
    
        @Override
        public void start() {
        }
    
        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(new FileReader(fileName));
                while (scanner.hasNext()) {
                    stringList.add(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

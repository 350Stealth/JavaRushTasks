package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ReadThread> threadArrayList = new ArrayList<>();
        String name = scanner.nextLine();
        while (!name.equals("exit")) {
            threadArrayList.add(new ReadThread(name));
            int last = threadArrayList.size();
            threadArrayList.get(last - 1).start();
            name = scanner.nextLine();
        }
        /*////
        for (Map.Entry<String, Integer> item : resultMap.entrySet()
        ) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
        ////*/
    }
    
    public static class ReadThread extends Thread {
        String fileName;
        
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        
        @Override
        public void run() {
//            super.run();
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
//                Scanner scanner = new Scanner(inputStream);
//                FileReader fileReader = new FileReader(fileName);
//                BufferedReader reader = new BufferedReader(fileReader);
                
                int maxByte = MaxByte(inputStream);
//                scanner.close();
                inputStream.close();
                synchronized (resultMap) {
                    resultMap.put(fileName, maxByte);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        private int MaxByte(FileInputStream scanner) throws Exception {
            Map<Integer, Integer> map = new TreeMap<>();
            while (scanner.available() > 0) {
                Integer buff = scanner.read();
                Integer count = map.putIfAbsent(buff, 1);
                if (count != null) {
                    count++;
                    map.put(buff, count);
                }
            }
            int[] max = new int[]{0, 0};
            for (Map.Entry<Integer, Integer> item : map.entrySet()
            ) {
                if (item.getValue() > max[1]) {
                    max[0] = item.getKey();
                    max[1] = item.getValue();
                }
            }
            return max[0];
        }

  /*  public static void main(String[] args) {

    }*/
/*
    public static class ReadThread extends Thread {
        private FileInputStream inputStream;
        
        public ReadThread(String fileName) throws Exception{
            //implement constructor body
            inputStream = new FileInputStream(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут
    
        @Override
        public void run() {
//            super.run();
            Scanner scanner = new Scanner(inputStream);
        }*/
    }
}

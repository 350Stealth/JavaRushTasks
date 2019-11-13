package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    
    public static void main(String[] args) {
    
    }
    
    public static class ReadThread extends Thread {
        String fileName;
        
        public ReadThread(String fileName) throws Exception {
            //implement constructor body
            
        }
        // implement file reading here - реализуйте чтение из файла тут
        
        @Override
        public void run() throws IOException{
//            super.run();
//            FileInputStream inputStream;
            FileInputStream inputStream = new FileInputStream(fileName);
            Scanner scanner = new Scanner(inputStream);
//            BufferedReader reader = new BufferedReader(inputStream);
            Map<Integer, Integer> map = new TreeMap<>();
            while (scanner.hasNextByte()) {
                int buff = scanner.nextByte();
                int count = map.putIfAbsent(buff, 1);
                if (count != -1) {
                    count++;
                    map.put(buff, count);
                }
            }
            scanner.close();
            inputStream.close();
            int[] max = new int[]{0, 0};
            for (Map.Entry<Integer, Integer> item : map.entrySet()
            ) {
                if (item.getValue() > max[1]) {
                    max[0] = item.getKey();
                    max[1] = item.getValue();
                }
            }
            
        }
    }
}

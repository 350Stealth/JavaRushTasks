package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        System.out.println(N);
        Set<Long> results = new TreeSet<>();
        for (long i = 1; i <= N; i++) {
/*            char[] digits = String.valueOf(i).toCharArray();
            int size = String.valueOf(i).length();
            long longNum = 0;
            for (char digChar: digits) {
                longNum = longNum + (long) Math.pow(Byte.parseByte(String.valueOf(digChar))*1.0, size*1.0);
                if (longNum >= N) break;
            }
//            System.out.print(i);
            if (longNum == i) {results.add(longNum);
                System.out.println(i + " - match!");}//;
//            System.out.println();*/
        }
        long[] result = null;
//        long[] result = new long[results.size()];
        /*int j = 0;
        for (Long resultLong: results) {
            result[j] = resultLong;
            j++;
        }*/
        System.out.println("Done!");
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        /*System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(5959458)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);*/
    
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/
public class Solution {
    
    public static long[] getNumbers(long N) {
        List<Long> list = generate(19);
    
        long[] result = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < N) {
                result = new long[i + 1];
            }
        }
    
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
        }
        
        System.out.println(Arrays.toString(result));
        return result;
    }
    
    private static int number;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;
    
    private static List<Long> results;
    private static long maxPow;
    private static long minPow;
    
    private static long[][] pows;
    
    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }
    
    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;
        
        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }
        
        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }
        
        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }
        return true;
    }
    
    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;
        
        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }
        
        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][number]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][number] < minPow) return;
            
            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][number];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }
    
    public static List<Long> generate(int maxN) {
        if (maxN >= 20) throw new IllegalArgumentException();
        
        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];
        
        for (number = 1; number <= maxN; number++) {
            minPow = (long) Math.pow(10, number - 1);
            maxPow = (long) Math.pow(10, number);
            
            search(9, number, 0);
        }
        
        Collections.sort(results);
        
        return results;
    }
    
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000L)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
        
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000L)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
        
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(59594589L)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(0L)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    }
}

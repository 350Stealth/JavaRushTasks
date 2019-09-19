package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer num1, num2;

//        try {
        num1 = Integer.parseInt(reader.readLine());
        if (num1 <= 0) throw new Exception();
        num2 = Integer.parseInt(reader.readLine());
        if (num2 <= 0) throw new Exception();
        int NOD;
           /* if ((num1 <= 0) || (num2 <= 0)) {
                throw new Exception();
            }*/
        
        if (num1.equals(num2)) {
            NOD = num1;
        } else {
            ArrayList<Integer> firstFactors = primeFactors(num1);
            ArrayList<Integer> secondFactors = primeFactors(num2);
            
            NOD = getNod(firstFactors, secondFactors);
        }
        
        System.out.println(NOD);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        reader.close();
    }
    
    public static int getNod(ArrayList<Integer> firstFactors, ArrayList<Integer> secondFactors) {
        int i = 0, j = 0, NOD = 1;
        while ((firstFactors.size() > 0) && (secondFactors.size() > 0)) {
            if (firstFactors.get(i).equals(secondFactors.get(j))) {
                NOD *= secondFactors.get(j);
                firstFactors.remove(i);
                secondFactors.remove(j);
            } else
                j++;
            if (j >= secondFactors.size()) {
                i++;
                j = 0;
            }
            if (i >= firstFactors.size()) break;
        }
        return NOD;
    }
    
    public static ArrayList<Integer> primeFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        BigInteger bigNum = new BigInteger("2");
        
        int nextPrime = 2;
        for (int i = nextPrime; i <= num; i++) {
            if (bigNum.isProbablePrime(i)) {
                while (num % i == 0) {
                    factors.add(i);
                    num = num / i;
                }
            }
        }
        return factors;
    }
}

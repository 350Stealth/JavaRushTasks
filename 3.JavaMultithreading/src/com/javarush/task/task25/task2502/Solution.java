package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception{
            //init wheels here
            wheels = new ArrayList<>();
            Set<String> wheelNames = new HashSet<>();
            for (Wheel item: Wheel.values()) {
                wheelNames.add(item.name());
            }
            
            if (wheelNames.size() != loadWheelNamesFromDB().length) {
                throw new Exception();
            }
            for (String item: loadWheelNamesFromDB()) {
                if (wheelNames.contains(item)) {
                    wheels.add(Wheel.valueOf(item));
                } else {
                    throw new Exception();
                }
            }
//            ---
            for (Wheel item: wheels) {
                System.out.println(item);
            }
//            ---
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
//            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
//            return new String[]{"FRONT_RIGHT", "FRONT_RIGHT", "BACK_LEFT"};
        }
    }

    public static void main(String[] args) throws Exception{
//        Car car = new Car();
    }
}

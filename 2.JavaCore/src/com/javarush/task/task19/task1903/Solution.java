package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;
    
        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }
    
        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }
    
        @Override
        public String getCountryName() {
            return null;
        }
    
        @Override
        public String getName() {
            return String.format("%s, %s", incomeData.getContactLastName(), incomeData.getContactFirstName());
        }
    
        @Override
        public String getPhoneNumber() {
            String phoneCode = String.valueOf(incomeData.getCountryPhoneCode());
            String phoneGSMCode = String.valueOf(incomeData.getPhoneNumber()).substring(0, 3);
            String line = String.format("+%d(%s)%s", incomeData.getCountryPhoneCode(), phoneCode);
            return null;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
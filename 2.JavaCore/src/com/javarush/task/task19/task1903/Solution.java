package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    
    static {
        countries.put("RU", "Russia");
        countries.put("UA", "Ukraine");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
    
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
    
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }
    
        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
    
        @Override
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }
    
        @Override
        public String getPhoneNumber() {
            /*int phoneCode = data.getCountryPhoneCode();
            int phoneNumber = data.getPhoneNumber();
            int phoneGSMCode = phoneNumber / 10000000;
            int numGroup1 = (phoneNumber - phoneGSMCode * 10000000) / 10000;
            int numGroup2 = (phoneNumber - phoneGSMCode * 10000000 - numGroup1 * 10000) / 100;
            int numGroup3 = phoneNumber - phoneGSMCode * 10000000 - numGroup1 * 10000 - numGroup2 * 100;
            return String.format("%+d(%03d)%s-%s-%s", phoneCode, phoneGSMCode, numGroup1, numGroup2, numGroup3);*/
            int phoneCode = data.getCountryPhoneCode();
            String phoneNumber = String.format("%010d", data.getPhoneNumber());
            String phoneGSMCode = phoneNumber.substring(0, 3);
            String numGroup1 = phoneNumber.substring(3, 6);
            String numGroup2 = phoneNumber.substring(6, 8);
            String numGroup3 = phoneNumber.substring(8);
            return String.format("%+d(%s)%s-%s-%s", phoneCode, phoneGSMCode, numGroup1, numGroup2, numGroup3);
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
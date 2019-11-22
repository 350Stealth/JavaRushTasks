package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    
    public static void main(String[] args) {
        
        /*////
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }
    
            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }
    
            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        
        DataAdapter adapter = new DataAdapter(customer, contact);
        System.out.println(adapter.getCompany());
        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getDialString());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getContactFirstName());
        ////*/
        
    }
    
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        
        @Override
        public String getCountryCode() {
            String line = "";
            for (Map.Entry<String, String> item : countries.entrySet()
            ) {
                if (item.getValue().equals(customer.getCountryName())) {
                    line = item.getKey();
                    break;
                }
            }
            return line;
        }
        
        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }
        
        @Override
        public String getContactFirstName() {
            String[] names = contact.getName().split("\\W");
//            System.out.println(names.length);   //
//            for (String item: names) {          //
//                System.out.println(item);       //
//            }                                   //
            return names[2];
        }
        
        @Override
        public String getContactLastName() {
            String[] names = contact.getName().split("\\W");
            return names[0];
        }
        
        @Override
        public String getDialString() {
            String number = contact.getPhoneNumber().replaceAll("\\D", "");
            return String.format("callto://+%s", number);
        }
    }
    
    public static interface RowItem {
        String getCountryCode();        //For example: UA
        
        String getCompany();            //For example: JavaRush Ltd.
        
        String getContactFirstName();   //For example: Ivan
        
        String getContactLastName();    //For example: Ivanov
        
        String getDialString();         //For example: callto://+380501234567
    }
    
    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        
        String getCountryName();        //For example: Ukraine
    }
    
    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
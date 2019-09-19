package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
������
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("����");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " ����� ������� � ������� " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //�������� ��� ��� ���
//            Money uah = new Hrivna(1500.0);
//            System.out.println(uah.getAmount() + " " + uah.getCurrencyName());
            this.allMoney.add(new Hrivna(1500));
            this.allMoney.add(new Ruble(35000));
            this.allMoney.add(new USD(2500));
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}

package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{
    private final String COUNTRY = Country.BELARUS;
    private final int EGGS_PER_MONTH = 28;
    
    @Override
    public int getCountOfEggsPerMonth() {
        return EGGS_PER_MONTH;
    }
    
    @Override
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + COUNTRY + ". Я несу " + EGGS_PER_MONTH + " яиц в месяц.");
    }
}

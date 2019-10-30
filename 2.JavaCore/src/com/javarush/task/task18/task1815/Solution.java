package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface component;
//        private String titleText;
        
        public TableInterfaceWrapper(TableInterface component) {
            this.component = component;
        }
        
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            component.setModel(rows);
        }
        
        @Override
        public String getHeaderText() {
//            return this.titleText.toUpperCase();
            return component.getHeaderText().toUpperCase();
        }
        
        @Override
        public void setHeaderText(String newHeaderText) {
//            this.titleText = newHeaderText;
            component.setHeaderText(newHeaderText);
        }
    }
    
    public interface TableInterface {
        void setModel(List rows);
        
        String getHeaderText();
        
        void setHeaderText(String newHeaderText);
    }
    
    public static void main(String[] args) {
    }
}
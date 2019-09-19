package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
        String grandDadName = reader.readLine();
        Cat catGrandDad = new Cat(grandDadName);
        
        String grandMomName = reader.readLine();
        Cat catGrandMom = new Cat(grandMomName);
        
        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandDad);
        
        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMom, null);
        
        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);
        
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandDad);
        System.out.println(catGrandMom);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMom;
        private Cat parentDad;

        Cat(String name) {
            this.name = name;
        }
        

        Cat(String name, Cat parentMom, Cat parentDad) {
            this.name = name;
            this.parentMom = parentMom;
            this.parentDad = parentDad;
        }

        @Override
        public String toString() {
            if ((parentMom == null) && (parentDad == null))
                return "The cat's name is " + name + ", no mother, no father ";
            else if ((parentDad == null) && (parentMom != null))
                return "The cat's name is " + name + ", mother is " + parentMom.name + ", no father";
            else if ((parentMom == null) && (parentDad != null))
                return "The cat's name is " + name + ", no mother, father is " + parentDad.name;
            else
                return "The cat's name is " + name + ", mother is " + parentMom.name + ", father is " + parentDad.name;
        }
    }

}

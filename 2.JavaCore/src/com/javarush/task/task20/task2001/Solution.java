package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/in.txt";
            File your_file_name = File.createTempFile(fileName, null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//            BufferedWriter writerTest = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\out.txt"));
            writer.write(this.name);
//            writerTest.write(this.name); //-----------
            if (this.assets.size() > 0) {
                for (Asset item: this.assets) {
                    writer.write(String.format("\n%s %s", item.getName(), item.getPrice()));
//                    writerTest.write(String.format("\n%s %s", item.getName(), item.getPrice())); //-----------
//                    System.out.println(String.format("\n%s %s", item.getName(), item.getPrice()));
                    writer.flush();
//                    writerTest.flush();
                }
            }
            writer.close();
//            writerTest.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNextLine()) {
//                System.out.println("Reading name");
                this.name = scanner.nextLine();
//                System.out.println(this.name);
            }
            while (scanner.hasNextLine()) {
                String line = scanner.next();
//                double number = scanner.nextDouble();
                String strNum = scanner.next();
//                System.out.println(line);
//                System.out.println(strNum);
                double number = Double.parseDouble(strNum);
//                System.out.println(number);
                this.assets.add(new Asset(line, number));
            }
            scanner.close();
        }
    }
}

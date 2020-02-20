package com.javarush.task.task20.task2002;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\in.txt";
            String fileName = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/in.txt";
            File yourFile = File.createTempFile(fileName, null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User ivanov = new User();
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            ivanov.setBirthDate(new Date());
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.RUSSIA);
            User petrova = new User();
            petrova.setFirstName("Anna");
            petrova.setLastName("Petrova");
            petrova.setBirthDate(new Date());
            petrova.setMale(false);
            petrova.setCountry(User.Country.UKRAINE);
            javaRush.users.add(ivanov);
            javaRush.users.add(petrova);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
//            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            String fileNameTest = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\out.txt"; //------------
            String fileNameTest = "/home/stealth/Projects/Java/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/out.txt";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedWriter writerTest = new BufferedWriter(new FileWriter(fileNameTest)); //-------------
            boolean flag = false;
            for (User item: this.users) {
                if (flag) {
                    writer.write("\n");
                    writerTest.write("\n");
                } else {
                    flag = true;
                }
                writer.write(String.format("%s %s\n", item.getFirstName(), item.getLastName()));
                writerTest.write(String.format("%s %s\n", item.getFirstName(), item.getLastName())); //-----------
                writer.write(String.format("%s\n",item.getBirthDate().toString()));
                writerTest.write(String.format("%s\n",item.getBirthDate().toString())); //-----------
                writer.write(item.isMale()? "Male" : "Female");
                writerTest.write(item.isMale()? "Male" : "Female"); //----------
                writer.write("\n");
                writerTest.write("\n"); //------------
                writer.write(String.format("%s", item.getCountry().getDisplayName()));
                writerTest.write(String.format("%s", item.getCountry().getDisplayName())); //-----------
            }
            writerTest.close(); //-------------
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

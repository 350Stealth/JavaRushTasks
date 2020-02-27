package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\in.txt";
            File yourFile = File.createTempFile(fileName, null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);
            
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User ivanov = new User();
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            ivanov.setBirthDate(new Date(83, 8, 20));
            ivanov.setMale(true);
            ivanov.setCountry(User.Country.RUSSIA);
            User petrova = new User();
            petrova.setFirstName("Julia");
            petrova.setLastName("Petrova");
            petrova.setBirthDate(new Date(91, 05, 12));
            petrova.setMale(false);
            petrova.setCountry(User.Country.UKRAINE);
            javaRush.users.add(ivanov);
            javaRush.users.add(petrova);
            javaRush.save(outputStream);
            outputStream.flush();
            
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            
            System.out.println(javaRush.equals(loadedObject));
            
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
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            boolean flag = false;
            for (User item : this.users) {
                if (flag) {
                    writer.write("\n");
                } else {
                    flag = true;
                }
                writer.write(String.format("%s %s\n", item.getFirstName(), item.getLastName()));
                writer.write(String.format("%s\n", item.getBirthDate().getTime()));
                writer.write(item.isMale() ? "Male" : "Female");
                writer.write("\n");
                writer.write(String.format("%s", item.getCountry().getDisplayName()));
            }
            writer.close();
        }
        
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                User newUser = new User();
                newUser.setFirstName(scanner.next());
                newUser.setLastName(scanner.next());
                long birthDate = scanner.nextLong();
//                System.out.println(birthDate);
                newUser.setBirthDate(new Date(birthDate));
//                System.out.println(newUser.getBirthDate());
                String sex = scanner.next();
                newUser.setMale(sex.equals("Male"));
                String userCountry = scanner.next();
                switch (userCountry) {
                    case "Russia":
                        newUser.setCountry(User.Country.RUSSIA);
                        break;
                    case "Ukraine":
                        newUser.setCountry(User.Country.UKRAINE);
                        break;
                    default:
                        newUser.setCountry(User.Country.OTHER);
                }
                users.add(newUser);
            }
            scanner.close();
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

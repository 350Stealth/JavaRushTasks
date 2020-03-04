package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.*;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2005\\file.txt";
//            File your_file_name = File.createTempFile(fileName, null);
            File your_file_name = new File(fileName);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            
            Human ivanov = new Human("Ivanov", new Asset("home", 5.0), new Asset("car", 18.0));
            ivanov.save(outputStream);
            outputStream.flush();
            
            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
//            System.out.println(ivanov.equals(ivanov));
            inputStream.close();
            
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
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Human human = (Human) o;
            
            if (name == null ? !name.equals(human.name) : human.name != null) return false;
            return Objects.equals(assets, human.assets);
            
        }
        
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return /*(int) (Math.random() * 100)*/ result;
        }
        
        public Human() {
        }
        
        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
        
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets) {
                    printWriter.println(current.getName());
                    printWriter.println(current.getPrice());
                }
            }
            printWriter.close();
        }
        
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            /*BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));
            reader.close();*/
            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNextLine()) {
                this.name = scanner.nextLine();
                System.out.println(this.name); //----------
            }
            while (scanner.hasNextLine()){
                String assetName = scanner.nextLine();
                System.out.println(assetName); //--------
                double assetPrice = Double.parseDouble(scanner.nextLine());
                System.out.println(assetPrice); //----------
                this.assets.add(new Asset(assetName, assetPrice));
            }
            scanner.close();
        }
    }
}

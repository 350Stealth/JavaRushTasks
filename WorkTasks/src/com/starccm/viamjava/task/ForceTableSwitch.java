package src.com.starccm.viamjava.task;

import java.io.*;
import java.util.Scanner;

public class ForceTableSwitch {
    
    public static void main(String[] args) {
        BufferedReader reader;
        Scanner scanner;
        BufferedWriter writer;
        final String COMMA = ",";
        
        System.out.println("Enter the file name:");
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            String fileNameNew;
            
            if (fileName.length() > 4) {
                fileNameNew = fileName.substring(0, fileName.length() - 4) + " mod.csv";
            } else {
                System.out.println("Filename is too short!");
                return;
            }
            
            reader.close();
            System.out.println("The name of the new file is:");
            System.out.println(fileNameNew);
            
            File file = new File(fileName);
            scanner = new Scanner(file).useDelimiter(COMMA);
            writer = new BufferedWriter(new FileWriter(fileNameNew));
            
            String line;
            String[] strings;
            String X, Y, Z, Pa;
            int counter = 5;
            
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                
                if (counter == 5) {
                    strings = line.split(COMMA);
                    Pa = strings[0];
                    X = strings[1];
                    Y = strings[2];
                    Z = strings[3];
                    line = X + COMMA + Y + COMMA + Z + COMMA + Pa;
    
                    writer.write(line);
                    writer.newLine();
                    counter = 0;
                } else
                    counter++;
            }
            
            writer.close();
            scanner.close();
    
            System.out.println("All done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

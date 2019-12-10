package src.com.starccm.viamjava.task;

import java.io.*;
import java.util.Scanner;

public class ForceTableSwitch {
    
    public static void main(String[] args) {
        BufferedReader reader;
        Scanner scanner;
        BufferedWriter writer;
        BufferedWriter writerMirror;
        final String COMMA = ",";
        
        System.out.println("Enter the file name:");
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            String fileNameNew;
            String fileNameNewMir;
            
            if (fileName.length() > 4) {
                String buff = fileName.substring(0, fileName.length() - 4);
                fileNameNew = buff + " mod.csv";
                fileNameNewMir = buff + " mod Z mirror.csv";
            } else {
                System.out.println("Filename is too short!");
                return;
            }
            
            reader.close();
            System.out.println("The name of the new file is:");
            System.out.println(fileNameNew);
            System.out.println("The name of the new mirror file is:");
            System.out.println(fileNameNewMir);
            
            File file = new File(fileName);
            scanner = new Scanner(file).useDelimiter(COMMA);
            writer = new BufferedWriter(new FileWriter(fileNameNew));
            writerMirror = new BufferedWriter(new FileWriter(fileNameNewMir));
            
            String line;
            String lineZMirror;
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
//                    if (Z.matches("\\-\\d*.*")) {
//
//                    }
                    try {
                        Double Z_double = Double.parseDouble(Z) * (-1.0);
                        Z = Z_double.toString();
                    } catch (Exception e) {
                    
                    }
                    lineZMirror = X + COMMA + Y + COMMA + Z + COMMA + Pa;
    
                    writer.write(line);
                    writer.newLine();
                    writerMirror.write(lineZMirror);
                    writerMirror.newLine();
                    counter = 0;
                } else
                    counter++;
            }
            
            writer.close();
            writerMirror.close();
            scanner.close();
    
            System.out.println("All done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

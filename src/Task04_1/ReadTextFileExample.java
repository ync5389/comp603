package Task04_1;

import java.io.*;
import java.util.ArrayList;

public class ReadTextFileExample {
public static ArrayList<String> readDataFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); // Add each line to the ArrayList
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
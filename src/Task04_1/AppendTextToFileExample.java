package Task04_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendTextToFileExample {
    public static void appendToFile(String filePath, String textToAppend) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(textToAppend);
            // System.out.println("Text appended successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

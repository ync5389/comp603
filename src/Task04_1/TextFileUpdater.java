package Task04_1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileUpdater {
    public static void updateTextInFile(String filePath, String oldText, String newText) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> updatedLines = lines.stream()
                    .map(line -> line.replace(oldText, newText))
                    .collect(Collectors.toList());

            Files.write(Paths.get(filePath), updatedLines);
            System.out.println("Text updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package org.example.SecondHomework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    // Запись данных в файл
    public void writeToFile(String data) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Data successfully written to file: " + filePath);
        } catch (IOException e) {
            throw new FileOperationException("Error writing to file: " + filePath, e);
        }
    }

    // Чтение данных из файла
    public String readFromFile() throws FileOperationException {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            return String.join("\n", lines);
        } catch (IOException e) {
            throw new FileOperationException("Error reading from file: " + filePath, e);
        }
    }
}

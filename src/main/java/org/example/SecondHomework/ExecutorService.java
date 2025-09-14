package org.example.SecondHomework;

import lombok.extern.slf4j.Slf4j;
import org.example.Executor;
import org.springframework.stereotype.Service;

@Slf4j
@Service("secondExecutorService")
public class ExecutorService implements Executor {
    @Override
    public void execution() {
        FileManager manager = new FileManager("myfile.txt");

        try {
            // Запись данных
            manager.writeToFile("Text to write to file");

            // Чтение данных
            String content = manager.readFromFile();
            System.out.println(content);

        } catch (FileOperationException e) {
            System.err.println("Error while working with file: " + e.getMessage());
        }
    }
}

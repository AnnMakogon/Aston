package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @Autowired
    //@Qualifier("firstExecutorService")    // First Homework
    @Qualifier("secondExecutorService")   // Second Homework
    private Executor executorService;

    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);
        Main main = context.getBean(Main.class);
        main.run();
    }

    public void run() {
        executorService.execution();
    }
}
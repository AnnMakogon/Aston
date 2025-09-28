package org.example.FourthHomework.TwoStreams;

import lombok.extern.slf4j.Slf4j;
import org.example.Executor;
import org.springframework.stereotype.Service;

@Slf4j
@Service("firthExecutorServiceTwoStreams")
public class ExecutorService implements Executor {

    @Override
    public void execution() {
        System.out.println("🚀 Запуск рабочих процессов IT компании\n");

        // Создаем отделы
        DepartmentCollaboration.DevelopmentDepartment backendDev = new DepartmentCollaboration.DevelopmentDepartment("Backend Department");
        DepartmentCollaboration.QADepartment qaTeam = new DepartmentCollaboration.QADepartment("QA Department");

        // Создаем и настраиваем потоки
        Thread devThread = new Thread(backendDev, "Backend-Dev");
        Thread qaThread = new Thread(qaTeam, "QA-Team");

        devThread.setDaemon(true);
        qaThread.setDaemon(true);

        // Запускаем отделы
        devThread.start();
        qaThread.start();

        // Работаем 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n🏢 Рабочий день завершен! Отлаженный процесс разработки!");
    }
}


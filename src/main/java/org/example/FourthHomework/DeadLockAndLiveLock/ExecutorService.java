package org.example.FourthHomework.DeadLockAndLiveLock;

import lombok.extern.slf4j.Slf4j;
import org.example.Executor;
import org.example.FourthHomework.TwoStreams.DepartmentCollaboration;
import org.springframework.stereotype.Service;

@Slf4j
@Service("firthExecutorServiceDLLock")
public class ExecutorService implements Executor {

    @Override
    public void execution() {
        System.out.println("🏢 ===== IT COMPANY CONCURRENCY DEMONSTRATION =====\n");

        try {
            // 1. ДЕМОНСТРАЦИЯ DEADLOCK
            System.out.println("1. 🔥 DEADLOCK DEMONSTRATION");
            System.out.println("=".repeat(45));
            demonstrateDeadlock();

            Thread.sleep(2000);

            // 2. ДЕМОНСТРАЦИЯ LIVELOCK
            System.out.println("\n2. 🔄 LIVELOCK DEMONSTRATION");
            System.out.println("=".repeat(45));
            demonstrateLivelock();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Демонстрация прервана!");
        }

        System.out.println("\n🎯 ===== DEMONSTRATION COMPLETED =====");
        System.out.println("Key Insights:");
        System.out.println("• DeadLock: Teams block each other waiting for resources");
        System.out.println("• LiveLock: Teams are too polite to make progress");
        System.out.println("• Solution: Proper resource management and clear protocols");
    }
    private static void demonstrateDeadlock() throws InterruptedException {
        // Создаем экземпляр CompanyDeadLock (предполагается, что этот класс в отдельном файле)
        CompanyDeadLock company = new CompanyDeadLock();

        // Используем мейн-логику из CompanyDeadLock
        CompanyDeadLock.DevelopmentTeam frontendTeam = company.new DevelopmentTeam("Frontend Team");
        CompanyDeadLock.DevelopmentTeam backendTeam = company.new DevelopmentTeam("Backend Team");

        Thread frontendThread = new Thread(frontendTeam, "Frontend-Thread");
        Thread backendThread = new Thread(backendTeam, "Backend-Thread");

        System.out.println("🚀 Starting deployment processes...");
        frontendThread.start();
        backendThread.start();

        // Даем поработать 3 секунды
        Thread.sleep(3000);

        // Проверяем deadlock
        if (frontendThread.isAlive() || backendThread.isAlive()) {
            System.out.println("\n💀 DEADLOCK DETECTED!");
            System.out.println("• Frontend Team waiting for Database Server");
            System.out.println("• Backend Team waiting for Production Server");
            System.out.println("• Both teams are blocked! CTO intervention required!");
        }

        // Завершаем потоки
        frontendThread.interrupt();
        backendThread.interrupt();

        frontendThread.join(1000);
        backendThread.join(1000);
    }

    private static void demonstrateLivelock() throws InterruptedException {
        // Создаем экземпляр CompanyLiveLock (предполагается, что этот класс в отдельном файле)
        CompanyLiveLock company = new CompanyLiveLock();

        // Используем мейн-логику из CompanyLiveLock
        CompanyLiveLock.TeamLead alice = company.new TeamLead("Alice", "Frontend");
        CompanyLiveLock.TeamLead bob = company.new TeamLead("Bob", "Backend");

        Thread aliceThread = new Thread(() -> alice.conductCodeReview(bob));
        Thread bobThread = new Thread(() -> bob.conductCodeReview(alice));

        System.out.println("🏢 Starting workday at IT company...");
        System.out.println("Team leads trying to conduct code reviews:\n");

        aliceThread.start();
        bobThread.start();

        // Даем поработать 8 секунд
        Thread.sleep(8000);

        System.out.println("\n🔄 LIVELOCK DETECTED: Team leads are too polite!");
        System.out.println("Need to establish clear code review schedule!");

        // Завершаем потоки
        aliceThread.interrupt();
        bobThread.interrupt();

        aliceThread.join(1000);
        bobThread.join(1000);
    }
}


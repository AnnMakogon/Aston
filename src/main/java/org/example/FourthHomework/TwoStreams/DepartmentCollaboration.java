package org.example.FourthHomework.TwoStreams;

//Синхронизированное взаимодействие отделов
public class DepartmentCollaboration {
    private static final Object syncLock = new Object();
    private static boolean isDevelopmentPhase = true;

    static class DevelopmentDepartment implements Runnable {
        private final String departmentName;

        public DevelopmentDepartment(String name) {
            this.departmentName = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (syncLock) {
                    // Ждем своей фазы - разработки
                    while (!isDevelopmentPhase) {
                        try {
                            System.out.println(departmentName + " ждет завершения тестирования...");
                            syncLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Фаза разработки
                    System.out.println("👨‍💻 " + departmentName + " разрабатывает функциональность");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    // Передаем работу тестировщикам
                    isDevelopmentPhase = false;
                    System.out.println("🔄 " + departmentName + " передает код на тестирование");

                    // Уведомляем все ожидающие потоки
                    syncLock.notifyAll();
                }
            }
        }
    }

    static class QADepartment implements Runnable {
        private final String departmentName;

        public QADepartment(String name) {
            this.departmentName = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (syncLock) {
                    // Ждем своей фазы - тестирования
                    while (isDevelopmentPhase) {
                        try {
                            System.out.println(departmentName + " ждет готовности кода...");
                            syncLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Фаза тестирования
                    System.out.println("🧪 " + departmentName + " тестирует функциональность");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    // Передаем обратно разработчикам
                    isDevelopmentPhase = true;
                    System.out.println("✅ " + departmentName + " завершил тестирование, возвращает разработчикам");

                    // Уведомляем все ожидающие потоки
                    syncLock.notifyAll();
                }
            }
        }
    }
}
